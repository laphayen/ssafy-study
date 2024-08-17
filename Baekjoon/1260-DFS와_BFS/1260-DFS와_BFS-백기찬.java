import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[][] g;
	static boolean [] visit1;
	static boolean [] visit2;
	static int n;
	static int m;
	static int v;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		v = sc.nextInt();
		
		g = new int[1001][1001];
		visit1 = new boolean[1001];
		visit2 = new boolean[1001];
		
		/*
		 * #1#
		 * 1##
		 * ###
		 *
		 * 대각선을 기준으로 대칭이다.
		 */
		
		
		// 그래프를 입력 받아서  - 간선의 개
		for (int i = 0; i < m; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			g[s][e] = 1;
			g[e][s] = 1;
		}
		
		/*
		 * 
		 * 1 2 4 3 -> dfs
		 * 1 2 3 4 -> bfs
		 */
		
		// dfs
		dfs(v);
		
		System.out.println("");
		
		// bfs
		bfs(v);
		
	}
	
	private static void dfs(int v) {
		// 현재 위치를 true로 표시
		visit1[v] = true;
		System.out.print(v+ " ");
		for (int i = 1; i <= n; i++) {
			if (g[v][i] == 1 && visit1[i] == false) {
				dfs(i);
			}
		}
		
	}
	
	private static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		// 큐에 현재 있는 것 넣고 시작!
		
		q.offer(v);
		// 현재 위치를 넣었으니
		// 방문 채크를 해버려
		visit2[v] = true;
		// 현재 요소 출력 ㄱ
		System.out.print(v+ " ");
		
		// 큐가 빌 때까지 돌아라
		while(!q.isEmpty()) {
			int tmp = q.poll();
			for (int i = 1; i < g.length; i++) {
				if (g[tmp][i] == 1 && visit2[i] == false) {
					q.offer(i);
					visit2[i] = true;
					System.out.print(i + " ");
				}
			}
		}
		
	}
	
	
}