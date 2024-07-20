import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), idx = 0, ans = 0;
		Integer dat[] = new Integer[12];
		while(N > 0) {
			dat[idx++] = N % 10;
			N /= 10;
		}
		
		Arrays.sort(dat, 0, idx, (a, b) -> b-a);
		for(int i = 0; i < idx; i++)
			ans = ans * 10 + dat[i];
		System.out.println(ans);
	}
}
