import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] dr = {1, -1, 0, 0, 1, 1, -1, -1};
	static int[] dc = {0, 0, 1, -1, 1, -1, 1, -1};
	static int[][] map;
	static int R, C;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			C = sc.nextInt(); R = sc.nextInt();
			if(R == 0 && C == 0) break;
			
			map = new int[R][C];
			for(int i = 0; i < R; i++)
				for(int j = 0; j < C; j++) 
					map[i][j] = sc.nextInt();
			
			int[][] flood = new int[R][C];
			int cnt = 0;
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					if(flood[i][j] != 0) continue;
					if(map[i][j] == 0) continue;
					cnt++;
						
					Queue<int[]> q = new ArrayDeque<int[]>();
					q.offer(new int[] {i, j});
					while(!q.isEmpty()) {
						int[] cur = q.poll();
						for(int d = 0; d < 8; d++) {
							int nr = cur[0] + dr[d], nc = cur[1] + dc[d];
							if(oob(nr, nc)) continue;
							if(map[nr][nc] == 0) continue;
							if(flood[nr][nc] != 0) continue;
							
							flood[nr][nc] = cnt;
							q.offer(new int[] {nr, nc});
						}
					}
				}
			}
			
			System.out.println(cnt);
		}
	}
	
	public static boolean oob(int r, int c) {
		return (r < 0 || r >= R || c < 0 || c >= C);
	}
}