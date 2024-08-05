import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int n = Integer.parseInt(br.readLine());
		
		int [][] map = new int [n][2];
		
		for (int i = 0; i<n; i++) {
			String[] str = br.readLine().split(" ");
			map[i][0] = Integer.parseInt(str[0]);
			map[i][1] = Integer.parseInt(str[1]);
		}
		
		Arrays.sort(map, (e1, e2) -> {
			if (e1[1] == e2[1]) {
				return e1[0] - e2[0];
			}
			else {
				return e1[1] - e2[1];
			}
		});
		
		for (int i = 0; i < n; i++) {
			System.out.println(map[i][0] + " "+ map[i][1]);
		}
	}
}