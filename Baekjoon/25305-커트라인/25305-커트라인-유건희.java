import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), k = sc.nextInt();
		int[] dat = new int[N];
		for(int i = 0; i < N; i++)
			dat[i] = sc.nextInt();
		Arrays.sort(dat);
		
		System.out.println(dat[N - k]);
	}
}
