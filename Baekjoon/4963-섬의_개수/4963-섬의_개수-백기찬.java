import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int land [][];
	static boolean [][] v;
	
	static int h;
	static int w;
	
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if (w == 0 && h == 0) {
				break;
			}
			
			land = new int [h][w];
			v = new boolean [h][w];
			int result = 0;
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					land[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i <h; i++) {
				for (int j = 0; j <w; j++) {
					if (!v[i][j] && land[i][j] == 1) {
						dfs(i, j);
						result +=1;
					}
				}
			}
			
			System.out.println(result);
		}
	}

	private static void dfs(int x, int y) {
		v[x][y] = true;
		
		for (int i =0; i<8; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			
			if (nx >= 0 && nx < h && ny >= 0 && ny < w && !v[nx][ny] && land[nx][ny] == 1) {
				dfs(nx, ny);
			}
		}
	}
}
