import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i = 1; i <= n; i++) {
			queue.offer(i);
		}
		
		while(queue.size() != 1) {
			queue.poll();
			int pop_n = queue.poll();
			queue.offer(pop_n);
		}
		
		System.out.println(queue.poll());
		
	}
}
