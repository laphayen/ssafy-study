import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Pair {
	public int x, y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Pair[] dat = new Pair[N];
		for(int i = 0; i < N; i++)
			dat[i] = new Pair(sc.nextInt(), sc.nextInt());
		
		Arrays.sort(dat, new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				if(o1.x != o2.x)
					return o1.x - o2.x;
				else
					return o1.y - o2.y;
			}
		});

		StringBuilder ans = new StringBuilder();
		for(int i = 0; i < N; i++)
		{
			ans.append(dat[i].x);
			ans.append(' ');
			ans.append(dat[i].y);
			ans.append('\n');
		}
		System.out.print(ans);
	}
}