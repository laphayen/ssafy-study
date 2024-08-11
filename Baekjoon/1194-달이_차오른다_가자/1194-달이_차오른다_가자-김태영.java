import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        Point sP = null;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '0') {
                    sP = new Point(i, j, 0, 0);
                }
            }
        }

        System.out.println(bfs(sP));
    }

    private static int bfs(Point sP) {
        Queue<Point> q = new LinkedList<Point>();
        q.offer(sP);

        boolean[][][] v = new boolean[N][M][00111111 + 1];

        while (!q.isEmpty()) {
            Point p = q.poll();

            int[] dr = { 0, 1, 0, -1 };
            int[] dc = { 1, 0, -1, 0 };

            for (int dir = 0; dir < 4; dir++) {
                int nr = p.r + dr[dir];
                int nc = p.c + dc[dir];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !v[nr][nc][p.keys]) {
                    if (map[nr][nc] >= 'a' && map[nr][nc] <= 'z') {
                        int nKeys = p.keys | (1 << (map[nr][nc] - 'a'));
                        q.offer(new Point(nr, nc, nKeys, p.cnt + 1));
                        v[nr][nc][nKeys] = true;
                    } else if (map[nr][nc] >='A' && map[nr][nc] <= 'Z') {
                        if ((p.keys & (1 << (map[nr][nc] - 'A'))) == (1 << (map[nr][nc] - 'A'))) {
                            q.offer(new Point(nr, nc, p.keys, p.cnt + 1));
                            v[nr][nc][p.keys] = true;
                        }
                    } else if (map[nr][nc] == '.' || map[nr][nc] == '0') {
                        q.offer(new Point(nr, nc, p.keys, p.cnt + 1));
                        v[nr][nc][p.keys] = true;
                    } else if (map[nr][nc] == '1') {
                        return p.cnt + 1;
                    }
                }
            }
        }
        return -1;
    }

    static class Point {
        int r, c;
        int keys;
        int cnt;

        public Point(int r, int c, int keys, int cnt) {
            super();
            this.r = r;
            this.c = c;
            this.keys = keys;
            this.cnt = cnt;
        }
    }
}
