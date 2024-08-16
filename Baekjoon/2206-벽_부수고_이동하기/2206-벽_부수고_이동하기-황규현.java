import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

class Loc {
	int b;
	int i;
	int j;
	
	Loc(int b, int i, int j) {
		this.b = b;
		this.i = i;
		this.j = j;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]), m = Integer.parseInt(str[1]);
		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			str = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		int[] dx = {1,-1,0,0}, dy = {0,0,1,-1};
		boolean [][][] v = new boolean[2][n][m];
		Queue<Loc> q = new ArrayDeque<Loc>();
		q.offer(new Loc(0, 0, 0));
		v[0][0][0] = true;
		int step = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				Loc cur = q.poll();
				if (cur.i == n-1 && cur.j == m-1) {
					System.out.println(step);
					return;
				}
				for (int d = 0; d < 4; d++) {
					int ni = cur.i + dx[d], nj = cur.j + dy[d];
					if (ni >= 0 && ni < n && nj >= 0 && nj < m && (!v[cur.b][ni][nj] || (cur.b == 0 && !v[1][ni][nj]))) {
						if (map[ni][nj] == 0) {
							v[cur.b][ni][nj] = true;
							q.offer(new Loc(cur.b, ni, nj));
						}
						else if (cur.b == 0) {
							v[cur.b+1][ni][nj] = true;
							q.offer(new Loc(1, ni, nj));
						}
					}
				}
			}
			step++;
		}
		System.out.println(-1);
	}
}
