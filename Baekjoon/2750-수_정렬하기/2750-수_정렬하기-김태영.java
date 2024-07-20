import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class Main
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        //selection sort
        for (int i = N - 1; i >= 0; i--) {
            int highestValueIdx = 0;
            for (int j = 0; j <= i; j++) {
                if (arr[j] > arr[highestValueIdx]) {
                    highestValueIdx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[highestValueIdx];
            arr[highestValueIdx] = temp;
        }

        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
	}
}
