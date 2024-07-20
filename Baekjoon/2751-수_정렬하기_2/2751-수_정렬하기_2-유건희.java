import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dat = new int[N];
		for(int i = 0; i < N; i++)
			dat[i] = sc.nextInt();
		Arrays.sort(dat);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++)
			sb.append(dat[i] + "\n");
		System.out.print(sb);
	}
}
