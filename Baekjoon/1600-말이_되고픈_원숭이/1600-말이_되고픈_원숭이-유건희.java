import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dr = {1, -1, 0, 0, 2, 2, 1, 1, -1, -1, -2, -2};
		int[] dc = {0, 0, 1, -1, 1, -1, 2, -2, 2, -2, 1, -1};
		
		int K = sc.nextInt(), M = sc.nextInt(), N = sc.nextInt();
		int map[][] = new int[N][M];
		boolean v[][][] = new boolean[K+1][N][M];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				map[i][j] = sc.nextInt();
		
		int ans = -1, step = 0;
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {0, 0, 0});
		v[0][0][0] = true;
		L : while(!q.isEmpty()) {
			int slim = q.size();
			for(int s = 0; s < slim; s++) {
				int[] cur = q.poll();
				if(cur[0] == N-1 && cur[1] == M-1) {
					ans = step;
					break L;
				}
				
				for(int d = 0; d < 12; d++) {
					int nr = cur[0] + dr[d], nc = cur[1] + dc[d];
					int ns = cur[2];
					if(oob(nr, nc, N, M)) continue;
					if(map[nr][nc] == 1) continue;
					if(d >= 4 && ns >= K) continue; 
					if(d >= 4)
						ns++;
					if(v[ns][nr][nc]) continue;
					
					v[ns][nr][nc] = true;
					q.offer(new int[] {nr, nc, ns});
				}
			}
			step++;
		}
		System.out.println(ans);
	}
	
	public static boolean oob(int r, int c, int N, int M) {
		return (r < 0 || r >= N || c < 0 || c >= M);
	}
}