import java.util.HashMap;
import java.util.Scanner;

public class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String b64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
		HashMap<Character, Integer> b64hm = new HashMap<>();
		for(int i = 0; i < 64; i++)
			b64hm.put(b64.charAt(i), i);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
			String estr = sc.next();
			StringBuilder ans = new StringBuilder();
			for(int i = 0; i < estr.length(); i += 4)
			{
				int buf = 0, mask = 0xff;
				StringBuilder tmp = new StringBuilder();
				
				for(int j = 0; j < 4; j++)
				{
					buf <<= 6;
					buf += b64hm.get(estr.charAt(i+j));
				}
				for(int j = 0; j < 3; j++)
				{
					tmp.append((char)(buf & mask));
					buf >>>= 8;
				}
				ans.append(tmp.reverse().toString());
			}
			System.out.println("#" + tc + " " + ans.toString());
		}
	}
}
