
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;

public class Solution {
	
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			
			int [] arr = new int [100];
			
			// 덤프 횟수 입력
			int dump = sc.nextInt();
			
			// 상자 입력 
			for (int i = 0; i<100; i++) {
				arr[i] = sc.nextInt();
			}
			
			for (int i = 0; i<dump; i++) {
				Arrays.sort(arr);
				arr[0]++;
				arr[99]--;
			}
			
			Arrays.sort(arr);
			
			int result = arr[99] - arr[0];
			
			System.out.println("#" + t + " " + result);
		}
	}
}
