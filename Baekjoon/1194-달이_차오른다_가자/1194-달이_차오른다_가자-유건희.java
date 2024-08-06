import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		int str = -1, stc = -1;
		int ans = -1;
		
		int[] dr = {1, -1, 0, 0};
		int[] dc = {0, 0, 1, -1};
		
		char[][] map = new char[N][M];
		boolean[][][] v = new boolean[1<<6][N][M];
		
		for(int i = 0; i < N; i++) {
			String line = sc.next();
			for(int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j] == '0') {
					str = i;
					stc = j;
				}
			}
		}
		
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {str, stc, 0, 0}); // r, c, step, key
		v[0][str][stc] = true;
		L : while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0], cc = cur[1], cstep = cur[2], ckey = cur[3];
			for(int d = 0; d < 4; d++) {
				int nr = cr + dr[d], nc = cc + dc[d], nkey = ckey;
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if(v[ckey][nr][nc]) continue;
				if(map[nr][nc] == '#') continue;
				
				if(map[nr][nc] == '1') {
					ans = cstep + 1;
					break L;
				} else if(map[nr][nc] >= 'a' && map[nr][nc] <= 'f') {
					nkey = ckey | (1 << (map[nr][nc] - 'a'));
				} else if(map[nr][nc] >= 'A' && map[nr][nc] <= 'F') {
					int chk = (ckey & (1 << (map[nr][nc] - 'A')));
					if(chk == 0) continue;
				} 
				q.add(new int[] {nr, nc, cstep + 1, nkey});
				v[nkey][nr][nc] = true;
			}
		}
		System.out.println(ans);
	}
}