import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][][] map;
	static int M, N, H;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][N][M];

		Queue<Point> q = new LinkedList<Point>();

		// 데이터 초기화
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; m++) {
					map[h][n][m] = Integer.parseInt(st.nextToken());
					// 익은 토마토가 있으면 Queue에 좌표를 넣음
					if (map[h][n][m] == 1) {
						q.offer(new Point(h, n, m));
					}
				}
			}
		}
		// 한턴 종료를 위한 null
		q.offer(null);

		int cnt = bfs(q);

		// 안익은 토마토 있나 찾아봄
		L:for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					if (map[h][n][m] == 0) {
						cnt = -1;
						break L;
					}
				}
			}
		}

		System.out.println(cnt);
	}

	private static int bfs(Queue<Point> q) {
		int cnt = 0;
		while (!q.isEmpty()) {
			Point p = q.poll();
			if (p == null) {
				if (!q.isEmpty()) {
					cnt++;					
					q.offer(null);
					continue;
				} else {					
					break;
				}
			}

			int[] dh = { 0, 0, 0, 0, 1, -1 };
			int[] dn = { 0, 1, 0, -1, 0, 0 };
			int[] dm = { 1, 0, -1, 0, 0, 0 };

			for (int dir = 0; dir < 6; dir++) {
				int nh = p.h + dh[dir];
				int nn = p.n + dn[dir];
				int nm = p.m + dm[dir];

				if (nh >= 0 && nh < H && nn >= 0 && nn < N && nm >= 0 && nm < M) {
					if (map[nh][nn][nm] == 0) {
						q.offer(new Point(nh, nn, nm));
						map[nh][nn][nm] = 1;
					}
				}
			}
		}

		return cnt;
	}

	static class Point {
		int h, n, m;

		Point(int h, int n, int m) {
			super();
			this.h = h;
			this.n = n;
			this.m = m;
		}
	}
}
