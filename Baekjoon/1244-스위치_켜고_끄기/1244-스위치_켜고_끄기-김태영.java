import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int swn = sc.nextInt();
		
		int[] sws = new int[swn + 1];
		sws[0] = -1;
		for (int i = 1; i < sws.length; i++) {
			sws[i] = sc.nextInt();
		}
		
		int sn = sc.nextInt();
		
		for (int i = 0; i < sn; i++) {
			int g = sc.nextInt();
			int n = sc.nextInt();
			
			if (g == 1) { //남자
				for (int j = 1; j * n < sws.length; j++) {
					sws[j * n] = sflip(sws[j * n]);
				}
			} else { // 여자
				sws[n] = sflip(sws[n]);
				for (int a = n - 1, b = n + 1; a >= 0 && b <= swn; a--, b++) {
					if (sws[a] == sws[b]) {
						sws[a] = sflip(sws[a]);
						sws[b] = sflip(sws[b]);
					} else {
						break;
					}
				}
			}
		}
		
		for (int i = 1; i < sws.length; i++) {
			System.out.print(sws[i]);
			
			if (i % 20 == 0) {
				System.out.println();
			} else if (i != swn){
				System.out.print(" ");
			}
			
		}
	}
	public static int sflip(int t) {
		if (t == 0) {
			return 1;
		} else {
			return 0;
		}
	}
}
