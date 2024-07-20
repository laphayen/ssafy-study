import java.util.Arrays;
import java.util.Scanner;

class Member {
	public static int cnt = 0;
	int age, idx;
	String name;
	public Member(int age, String name) {
		this.idx = cnt++;
		this.age = age;
		this.name = name;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Member[] mems = new Member[N];
		
		for(int i = 0; i < N; i++) {
			mems[i] = new Member(sc.nextInt(), sc.next());
		}
		
		Arrays.sort(mems, (o1, o2) -> {
			if(o1.age != o2.age)
				return o1.age - o2.age;
			else
				return o1.idx - o2.idx;
		});
		
		StringBuilder ans = new StringBuilder();
		for(int i = 0; i < N; i++)
		{
			ans.append(mems[i].age);
			ans.append(' ');
			ans.append(mems[i].name);
			ans.append('\n');
		}
		System.out.print(ans);
	}
}