import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Tuple> q = new ArrayDeque<Tuple>();
		int M = sc.nextInt(), N = sc.nextInt(), H = sc.nextInt();
		int[][][] grid = new int[H][N][M];
		boolean[][][] v = new boolean[H][N][M];
		int tcount = 0, date = 0;
		
		for(int k = 0; k < H; k++)
			for(int i = 0; i < N; i++)
				for(int j = 0; j < M; j++) {
					grid[k][i][j] = sc.nextInt();
					if(grid[k][i][j] == 0)
						tcount++;
					if(grid[k][i][j] == 1) {
						q.add(new Tuple(k, i, j));
						v[k][i][j] = true;
					}
				}
		
		int[] dk = {1, -1, 0, 0, 0, 0};
		int[] di = {0, 0, 1, -1, 0, 0};
		int[] dj = {0, 0, 0, 0, 1, -1};
		
		while(!q.isEmpty()) {
			date++;
			int lim = q.size();
			for(int d = 0; d < lim; d++) {
				Tuple t = q.poll();
				for(int r = 0; r < 6; r++) {
					int nk = t.k + dk[r], ni = t.i + di[r], nj = t.j + dj[r];
					if(OOB(nk, ni, nj, H, N, M)) continue;
					if(v[nk][ni][nj]) continue;
					if(grid[nk][ni][nj] != 0) continue;
					
					v[nk][ni][nj] = true;
					grid[nk][ni][nj] = 1;
					tcount--;
					q.offer(new Tuple(nk, ni, nj));
				}
			}
		}
		
		if(tcount != 0) System.out.println(-1);
		else System.out.println(date - 1);
	}
	
	public static boolean OOB(int k, int i, int j, int H, int N, int M) {
		return (k < 0 || k >= H || i < 0 || i >= N || j < 0 || j >= M);
	}
}

class Tuple{
	int k, i, j;
	Tuple(int k, int i, int j) {
		this.k = k;
		this.i = i;
		this.j = j;
	}
}