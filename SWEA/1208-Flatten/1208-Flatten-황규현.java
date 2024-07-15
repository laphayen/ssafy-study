import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T = 10;
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int[] arr = new int[100];
            int n = sc.nextInt();
            for (int i = 0; i < 100; i++) arr[i] = sc.nextInt();
            Arrays.sort(arr);

            while (n-- > 0) {
                arr[0] += 1;
                arr[99] -= 1;
                Arrays.sort(arr);
            }

            System.out.println("#" + test_case + " " + (arr[99] - arr[0]));

		}
	}
}
