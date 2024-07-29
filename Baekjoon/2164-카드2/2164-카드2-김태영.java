import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class Main
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();

        Queue<Integer> q = new LinkedList<Integer>();

        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        int lastValue = -1;
        for (int i = 1; q.size() != 1; i++) {
            if (i % 2 == 0) {
                q.add(q.remove());
            } else {
                q.remove();
            }
        }

        System.out.println(q.peek());
	}
}
