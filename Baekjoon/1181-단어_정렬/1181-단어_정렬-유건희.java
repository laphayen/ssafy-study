import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashSet<String> hs = new HashSet<>();
		
		int N = sc.nextInt();
		for(int i = 0; i < N; i++)
			hs.add(sc.next());
		
		String[] ans = Arrays.copyOf(hs.toArray(), hs.size(), String[].class);
		/*
		 * Same as below
		 * Object[] objs = hs.toArray();
		 * for(int i = 0; i < hs.size(); i++)
		 * 		ans[i] = (String) objs[i];
		 */
		
		Arrays.sort(ans, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if(s1.length() != s2.length())
					return s1.length() - s2.length();
				else
					for(int i = 0; i < s1.length(); i++)
						if(s1.charAt(i) != s2.charAt(i))
							return s1.charAt(i) - s2.charAt(i);
				return 0;
			}
		});
		
		for(int i = 0; i < ans.length; i++)
			System.out.println(ans[i]);
	}
}