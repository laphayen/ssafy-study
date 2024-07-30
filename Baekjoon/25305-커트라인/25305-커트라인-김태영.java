
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class Main
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        arr = mergeSort(arr);
        System.out.println(arr[k - 1]);
	}


    public static int[] mergeSort(int[] arr) {
        if (arr.length == 1) return arr;

        int mid = arr.length / 2; // middle value
        int[] la = Arrays.copyOfRange(arr, 0, mid); // left arr
        int[] ra = Arrays.copyOfRange(arr, mid, arr.length); // right arr
        
        return merge(mergeSort(la), mergeSort(ra));
    }

    public static int[] merge(int[] la, int[] ra) {
        int[] na = new int[la.length + ra.length]; // new arr

        int i = 0, li = 0, ri = 0;
        
        while(true) {
            if (la[li] < ra[ri]) {
                na[i++] = ra[ri++];
            } else {
                na[i++] = la[li++];
            }

            // when one side of array is sorted, copy rest of another array to new array
            if (li == la.length) {
                System.arraycopy(ra, ri, na, i, ra.length - ri);
                na[i] = ra[ri];
                break;
            } else if (ri == ra.length) {
                System.arraycopy(la, li, na, i, la.length - li);
                na[i] = la[li];
                break;
            }
        }

        return na;
    }
}
