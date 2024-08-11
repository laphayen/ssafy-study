import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static char[][] map;
	static Queue<Point> q = new LinkedList<Point>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		Point S = null;
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'S') {
					S = new Point(i, j, 0, false);
					map[i][j] = '.';
				} else if (map[i][j] == '*') {
					q.offer(new Point(i, j, 0, true));
				}
			}
		}
		int result = bfs(S);
		System.out.println(result == -1 ? "KAKTUS" : result);
	}
	
	private static int bfs(Point sP) {
		boolean[][] v = new boolean[R][C];
		q.offer(sP);
		
		v[sP.r][sP.c] = true; 
		
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			if (!p.isWater && map[p.r][p.c] == 'D') {
				return p.cnt;
			}
			
			int[] dr = {1, 0, -1, 0};
			int[] dc = {0, 1, 0, -1};
			for (int dir = 0; dir < 4; dir++) {
				int nr = p.r + dr[dir];
				int nc = p.c + dc[dir];
				
				if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
					if (p.isWater) { // 물인 경우
						if (map[nr][nc] == '.') {
							map[nr][nc] = '*';
							q.offer(new Point(nr, nc, p.cnt + 1, true));							
						}
					} else { // 고슴도치 인 경우
						if ((map[nr][nc] == '.' || map[nr][nc] == 'D') && !v[nr][nc]) {
							v[nr][nc] = true;
							q.offer(new Point(nr, nc, p.cnt + 1, false));
						}
						
					}
				}
			}
		}
		return -1;
	}
	
	static class Point {
		int r, c, cnt;
		boolean isWater;

		public Point(int r, int c, int cnt, boolean isWater) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.isWater = isWater;
		}
	}
}
