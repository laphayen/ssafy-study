import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int[] dat = new int[5];
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 5; i++)
			dat[i] = sc.nextInt();
		
		Arrays.sort(dat);
		System.out.println((int)(Arrays.stream(dat).average().orElse(-1)));
		System.out.println(dat[2]);
	}
}
