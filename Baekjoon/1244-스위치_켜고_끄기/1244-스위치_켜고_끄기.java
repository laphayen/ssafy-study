import java.util.Scanner;

public class Main {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean sw[] = new boolean[N+1];
		for(int i = 1; i <= N; i++)
			sw[i] = (sc.nextInt() == 0 ? false : true);
		
		int M = sc.nextInt();
		for(int i = 0; i < M; i++)
		{
			int gender = sc.nextInt();
			int num = sc.nextInt();
			if(gender == 1)
			{
				for(int j = num; j <= N; j += num)
					sw[j] = !sw[j];
			}
			else
			{
				int cnt = 1;
				sw[num] = !sw[num];
				while(num - cnt >= 1 && num + cnt <= N)
					if(sw[num - cnt] == sw[num + cnt])
					{
						sw[num - cnt] = !sw[num - cnt];
						sw[num + cnt] = !sw[num + cnt];
						cnt++;
					}
					else
						break;
			}
		}

		for(int i = 1; i <= N; i++)
		{
			System.out.print((sw[i] == true ? 1 : 0) + " ");
			if(i % 20 == 0) System.out.println();
		}
	}