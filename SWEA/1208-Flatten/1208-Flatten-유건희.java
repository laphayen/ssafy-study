import java.util.Arrays;
import java.util.Scanner;
 
public class Solution {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = 10;
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int dmp = sc.nextInt();
            int dat[] = new int[100];
            for(int i = 0; i < 100; i++)
                dat[i] = sc.nextInt();
 
            Arrays.sort(dat);
            for(int i = 0; i < dmp; i++)
            {
                dat[0]++;
                dat[99]--;
                Arrays.sort(dat);
            }
             
            System.out.println("#" + test_case + " " + (dat[99] - dat[0]));
        }
    }
}