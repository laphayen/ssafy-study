import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int c = sc.nextInt(); // column
		int r = sc.nextInt(); // row
		
		int tl = c * 2 + r * 2;

		// 1차원 전체길이, 좌측 위를 시작점으로 놓음

		int s = sc.nextInt(); // 상점개수

		int[] d = new int[s + 1];

		for (int i = 0; i < s + 1; i++) {
			int loc = sc.nextInt(); // 1 북, 2 남, 3 서, 4 동
			int dis = sc.nextInt();

			switch (loc) {
			case 1:
				d[i] = dis;
				break;
			case 2:
				d[i] = r + c * 2 - dis;
				break;
			case 3:
				d[i] = r * 2 + c * 2 - dis;
				break;
			case 4:
				d[i] = c + dis;
				break;
			}
		}

		int sSum = 0;
		for (int j = 0; j < s; j++) {
			d[j] = Math.abs(d[j] - d[s]);

			if (d[j] <= tl / 2) {
				sSum += d[j];
			} else {
				sSum += tl - d[j];
			}
		}

		System.out.println(sSum);
	}
}
