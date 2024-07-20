import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class Main
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

        int avg = 0;
        int middle = 0;

        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
            avg += arr[i];
        }
        avg /= 5;

        // bubble sort
        for (int i = 5 - 1; i >= 0;) {
            int notChangedCnt = 0;
            for (int j = 0; j <= i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    notChangedCnt = 0;
                } else {
                    notChangedCnt++;
                }
            }

            if (notChangedCnt != 0) {
                i -= notChangedCnt + 1;
            } else {
                i--;
            }
        }

        System.out.println(avg);
        System.out.println(arr[2]);
	}
}
