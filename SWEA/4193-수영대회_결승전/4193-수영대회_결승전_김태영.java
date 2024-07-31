import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
 
public class Solution {
    static int[][] map;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
 
        for (int testCase = 1; testCase <= T; testCase++) {
            N = sc.nextInt();
 
            map = new int[N][N];
 
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
             
            Point sP = new Point(sc.nextInt(), sc.nextInt());
            Point eP = new Point(sc.nextInt(), sc.nextInt());
 
 
            System.out.printf("#%d %d\n", testCase, bfs(sP, eP, new boolean[N][N]));
        }
    }
 
    private static int bfs(Point sP, Point eP, boolean[][] v) {
        Queue<Point> q = new ArrayDeque<Point>();
        Queue<Integer> cntQ = new ArrayDeque<Integer>();
        int cnt = -1;
 
        q.offer(sP);
        cntQ.offer(0);
 
        boolean reached = false;
        while (!q.isEmpty()) {
            Point p = q.poll();
            cnt = cntQ.poll();
 
            // 종료조건
            if (p.x == eP.x && p.y == eP.y) {
                reached = true;
                break;
            }
 
            v[p.y][p.x] = true;
 
            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0 ,-1, 0};
 
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
 
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !v[ny][nx]) {
 
                    if (map[ny][nx] == 2) {
                        if (cnt % 3 == 2) {
                            q.offer(new Point(ny, nx));
                        } else {
                            q.offer(p);
                        }
                    } else if (map[ny][nx] == 1) {
                        continue;
                    } else if (map[ny][nx] == 0) {
                        q.offer(new Point(ny, nx));
                    }
                    cntQ.offer(cnt + 1);
                }
            }
        }
        return reached ? cnt : -1;
    }
 
    static class Point {
        int x;
        int y;
        public Point(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
}
