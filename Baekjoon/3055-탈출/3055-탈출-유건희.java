import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt(), C = sc.nextInt();
		int[] dr = {1, -1, 0, 0};
		int[] dc = {0, 0, 1, -1};
		char[][] map = new char[R][C];
		int[][] flood = new int[R][C];
		boolean[][] v = new boolean[R][C];
		
		Queue<Pos> q = new ArrayDeque<>();
		Pos player = null, target = null;
		List<Pos> water = new ArrayList<>();
		
		for(int i = 0; i < R; i++) {
			String line = sc.next();
			for(int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
				flood[i][j] = Integer.MAX_VALUE;
				switch(map[i][j]) {
				case 'S' :
					player = new Pos(i, j);
					break;
				case 'D' :
					target = new Pos(i, j);
					break;
				case '*' :
					flood[i][j] = 0;
					water.add(new Pos(i, j));
					break;
				}
			}
		}
		
		for(Pos w : water)
			q.offer(w);
		
		while(!q.isEmpty()) {
			Pos curw = q.poll();
			int curdepth = flood[curw.r][curw.c];
			for(int d = 0; d < 4; d++) {
				int nr = curw.r + dr[d], nc = curw.c + dc[d];
				if(OOB(nr, nc, R, C)) continue;
				if(flood[nr][nc] <= curdepth + 1) continue;
				if(map[nr][nc] == '.' || map[nr][nc] == 'S') {
					flood[nr][nc] = curdepth + 1;
					q.offer(new Pos(nr, nc));
				}
			}
		}
		
		int ans = -1, cnt = 1;
		q.offer(player);
		v[player.r][player.c] = true;
		L : while(!q.isEmpty()) {
			int qsize = q.size();
			
			for(int i = 0; i < qsize; i++) {
				Pos curp = q.poll();
				for(int d = 0; d < 4; d++) {
					int nr = curp.r + dr[d], nc = curp.c + dc[d];
					if(OOB(nr, nc, R, C)) continue;
					if(map[nr][nc] == 'D') {
						ans = cnt;
						break L;
					}
					if(v[nr][nc]) continue;
					if(map[nr][nc] == 'X') continue;
					if(flood[nr][nc] <= cnt) continue;
					
					v[nr][nc] = true;
					q.offer(new Pos(nr, nc));
				}
			}
			cnt++;
		}
		
		System.out.println((ans == -1) ? "KAKTUS" : ans);
	}
	
	public static boolean OOB(int r, int c, int R, int C) {
		return (r < 0 || r >= R || c < 0 || c >= C);
	}
}

class Pos {
	int r, c;
	Pos(int r, int c) {
		this.r = r;
		this.c = c;
	}
}