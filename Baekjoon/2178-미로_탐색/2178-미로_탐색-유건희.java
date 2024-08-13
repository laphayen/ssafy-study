import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		int[] dr = {1, -1, 0, 0};
		int[] dc = {0, 0, 1, -1};
		int[][] map = new int[N][M];
		boolean[][] v = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String line = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0, 0, 1});
		v[0][0] = true;
		
		int ans = -1;
		L : while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(cur[0] == N-1 && cur[1] == M-1) {
				ans = cur[2];
				break L;
			}
			for(int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d], nc = cur[1] + dc[d];
				if(oob(nr, nc, N, M)) continue;
				if(v[nr][nc]) continue;
				if(map[nr][nc] == 0) continue;
				
				q.offer(new int[] {nr, nc, cur[2] + 1});
				v[nr][nc] = true;
			}
		}
		
		System.out.println(ans);
	}
	
	public static boolean oob(int r, int c, int N, int M) {
		return (r < 0 || r >= N || c < 0 || c >= M);
	}
}