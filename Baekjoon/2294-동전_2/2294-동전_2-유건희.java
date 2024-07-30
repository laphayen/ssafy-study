import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), k = sc.nextInt();
		
		int[] coins = new int[n];
		int[] dp = new int[k + 1];
		
		for(int i = 0; i < n; i++)
			coins[i] = sc.nextInt();
		
		for(int m = 1; m <= k; m++) {
			dp[m] = Integer.MAX_VALUE;
			for(int i = 0; i < n; i++) {
				if(m - coins[i] < 0) continue;
				if(dp[m - coins[i]] == Integer.MAX_VALUE) continue;
				dp[m] = Math.min(dp[m], dp[m - coins[i]] + 1);
			}
		}
		
		System.out.println((dp[k] == Integer.MAX_VALUE) ? -1 : dp[k]);
	}
}