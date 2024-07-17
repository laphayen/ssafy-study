import java.util.Scanner;

public class Main {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int W = sc.nextInt(), H = sc.nextInt();
		int S = sc.nextInt();
		int dir[] = new int[S], pos[] = new int[S];
		int clk[] = {-1, 4, 3, 1, 2}; // clockwise next
		int hrz[] = {-1, W, W, H, H}; // horizon
		
		for(int i = 0; i < S; i++)
		{
			dir[i] = sc.nextInt();
			pos[i] = sc.nextInt();
			if(dir[i] == 2 || dir[i] == 3)
				pos[i] = hrz[dir[i]] - pos[i];
		}
		
		int pdir = sc.nextInt(), ppos = sc.nextInt();
		if(pdir == 2 || pdir == 3)
			ppos = hrz[pdir] - ppos;
		int ans = 0;
		
		for(int i = 0; i < S; i++)
		{
			int dist = hrz[pdir] - ppos, cdir = clk[pdir];
			while(cdir != dir[i])
			{
				dist += hrz[cdir];
				cdir = clk[cdir];
			}
			dist += pos[i];
			dist %= 2*W + 2*H;
			ans += Math.min(dist, 2*W + 2*H - dist);
		}
		System.out.println(ans);
	}
}