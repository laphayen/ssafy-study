import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static int[][] map;
	static boolean[][][] v;
	static int R, C;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt(); C = sc.nextInt();
		map = new int[R][C];
		v = new boolean[2][R][C];
			
		for (int i = 0; i < R; i++) {
			String line = sc.next();
			for (int j = 0; j < C; j++)
				map[i][j] = line.charAt(j) - '0';
		}

		Queue<int[]> q = new ArrayDeque<int[]>();
		v[0][0][0] = true;
		q.add(new int[] {0, 0, 0});
		int ans = -1;
		int step = 0;
		
		L : while(!q.isEmpty()) {
			step++;
			int qsize = q.size();
			
			for(int qs = 0; qs < qsize; qs++) {
				int[] cur = q.poll();
				if(cur[1] == R - 1 && cur[2] == C - 1) {
					ans = Math.max(ans, step);
					break L;
				}
				
				for(int d = 0; d < 4; d++) {
					int nr = cur[1] + dr[d], nc = cur[2] + dc[d];
					int ns = cur[0];
					if(oob(nr, nc)) continue;
					if(v[ns][nr][nc]) continue;
					if(map[nr][nc] == 1) {
						if(ns == 1) continue;
						ns = 1;
					}
					v[ns][nr][nc] = true;
					q.add(new int[] {ns, nr, nc});
				}
			}
		}
		System.out.println(ans);
	}
	
	public static boolean oob(int r, int c) {
		return (r < 0 || r >= R || c < 0 || c >= C);
	}
}