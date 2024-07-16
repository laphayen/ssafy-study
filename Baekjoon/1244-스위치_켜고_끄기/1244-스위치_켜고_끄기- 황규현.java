import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), num;
		int[] sw = new int[n];
		for (int i = 0; i < n; i++) sw[i] = sc.nextInt();
		int std = sc.nextInt();
		for (int i = 0; i < std; i++) {
			switch (sc.nextInt()) {
			case 1:
				num = sc.nextInt();
				for (int j = num-1; j < n; j += num) {
					if (sw[j] == 1) sw[j] = 0;
					else sw[j] = 1;
				}
				break;
			default:
				num = sc.nextInt()-1;
				int lo = num-1, hi = num+1;
				while (lo >= 0 && hi < n) {
					if (sw[lo] != sw[hi]) {
						for (int j = lo + 1; j <= hi - 1; j++) {
							if (sw[j] == 1) sw[j] = 0;
							else sw[j] = 1;
						}
						break;
					}
					lo--;
					hi++;
				}
				if (lo < 0 || hi >= n) { // 마지막
					for (int j = lo + 1; j <= hi - 1; j++) {
						if (sw[j] == 1) sw[j] = 0;
						else sw[j] = 1;
					}
				}
				break;
			}
		}
		
		for (int i = 0; i < n; i++) {
			System.out.print(sw[i]+" ");
			if ((i+1) % 20 == 0) System.out.println();
		}
	}
}
