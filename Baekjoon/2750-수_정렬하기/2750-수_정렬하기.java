import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dat = new int[N];
		for (int i = 0; i < dat.length; i++) {
			dat[i] = sc.nextInt();
		}
		
		merge_sort(dat, 0, dat.length - 1);
		for (int i = 0; i < dat.length; i++)
			System.out.println(dat[i]);
	}
	
	private static void merge_sort(int[] arr, int from, int to) {
		if(from >= to) return;
		
		int mid = (from + to) / 2;
		merge_sort(arr, from, mid);
		merge_sort(arr, mid + 1, to);
		merge(arr, from, mid, to);
	}
	
	private static void merge(int[] arr, int l, int m, int r) {
		int[] buf = new int[r - l + 1];
		int ptrA = l, ptrB = m + 1;
		int idx = 0;
		while(ptrA <= m && ptrB <= r) {
			if(arr[ptrA] <= arr[ptrB])
				buf[idx++] = arr[ptrA++];
			else
				buf[idx++] = arr[ptrB++];
		}
		
		for(int i = ptrA; i <= m; i++)
			buf[idx++] = arr[i];
		for(int i = ptrB; i <= r; i++)
			buf[idx++] = arr[i];
		
		for(int i = 0; i < buf.length; i++)
			arr[l + i] = buf[i]; 
	}
}
