import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
//	public static void main(String[] args) {
//		
//		Scanner sc = new Scanner(System.in);
//		
//		int n = sc.nextInt();
//		int [][] map = new int [n][2];
//		
//		for (int i = 0; i < n; i++) {
//			int x = sc.nextInt();
//			int y = sc.nextInt();
//			
//			map[i][0] = x;
//			map[i][1] = y;
//		}
//		
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n-1; j++) {
//				if (map[i][0] < map[j][0]) {
//					int tmpX = map[i][0];
//					int tmpY = map[i][1];
//					map[i][0] = map[j][0];
//					map[i][1] = map[j][1];
//					map[j][0] = tmpX;
//					map[j][1] = tmpY;
//				}
//				else if (map[i][0] == map[j][0]) {
//					if (map[i][1] < map[j][1]) {
//						int tmpX = map[i][0];
//						int tmpY = map[i][1];
//						map[i][0] = map[j][0];
//						map[i][1] = map[j][1];
//						map[j][0] = tmpX;
//						map[j][1] = tmpY;
//					}
//				}
//			}
//		}
//		
//		for (int i = 0; i < n; i++) {
//			System.out.println(map[i][0] + " "+ map[i][1]);
//		}
//		
//	}
	
	
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
			if (e1[0] == e2[0]) {
				return e1[1] - e2[1];
			}
			else {
				return e1[0] - e2[0];
			}
		});
		
		for (int i = 0; i < n; i++) {
			System.out.println(map[i][0] + " "+ map[i][1]);
		}
	}
}