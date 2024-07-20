import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, Integer> hm = new HashMap<>();
		int N = sc.nextInt();
		int src[] = new int[N];
		
		for(int i = 0; i < N; i++)
			src[i] = sc.nextInt();

		int dat[] = Arrays.copyOf(src, N);
		Arrays.sort(dat);		
		hm.put(dat[0], 0);
		
		int prev = dat[0];
		int idx = 0;
		for(int i = 0; i < N; i++)
			if(prev != dat[i]) 
			{
				prev = dat[i];
				hm.put(dat[i], ++idx);
			}
		
		StringBuilder ans = new StringBuilder();
		for(int i = 0; i < N; i++)
			ans.append(hm.get(src[i]) + " ");
		System.out.println(ans);
	}
}