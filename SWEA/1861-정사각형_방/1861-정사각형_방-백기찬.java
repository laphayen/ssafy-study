import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	
	static int n;
	static int [][] map;
	static boolean [][] v;
	private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};
    static int resultRoom;
    static int resultCnt;
	
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());  // 테스트 케이스의 수
        
        // 테스트 수만큼 반복하거
        for (int t = 1; t <= T; t++) {
        	n = Integer.parseInt(br.readLine());
        	map = new int [n][n];
        	v = new boolean [n][n];
        	
        	// 배열 입
        	for(int i = 0; i<n; i++) {
        		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        		for (int j = 0; j < n; j++) {
        			map[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	// 잘 들어 갔는지확인
//        	for (int i = 0; i < n; i++) {
//        		System.out.println(Arrays.toString(map[i]));
//        	}
        	// 응 잘 들어갔어
        	
        	int temp = 0;
        	int room = 0;
        	int cnt = 0;
        	for (int i = 0; i < n; i++) {
        		for (int j = 0; j <n; j++) {
        			// 각 행을 기준으로 bfs를 돌아보자. -v확
        			if (!v[i][j]) {
        				temp = bfs(i, j, 1);
        				if (temp > cnt) {
        					cnt = temp;
        					room = map[i][j];
        				} else if (temp == cnt && map[i][j] < room) {
                            room = map[i][j];
                        }
        			}
        		}
        	}
        	System.out.println("#" + t + " " + room + " " + cnt);

        }
    }


	private static int bfs(int r, int c, int cnt) {
		Queue<Point> q = new ArrayDeque<>();
		q.offer(new Point(r, c));
		v[r][c] = true;
		
		while (!q.isEmpty()) {
			Point np = q.poll();
			v[np.r][np.c] = true;
			
			for (int i = 0; i<4; i++) {
				int nr = dr[i] + np.r;
				int nc = dc[i] + np.c;
				
				if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
					if (map[nr][nc] == map[np.r][np.c] +1) {
						v[nr][nc] = true;
						q.offer(new Point(nr, nc));
						cnt ++;
					}
				}
			}
		}
		return cnt;
	}
}


class Point {
    int r, c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}