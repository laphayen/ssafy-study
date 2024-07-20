import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] dat = new int[N];
		int[] count = new int[10000];
		
		for(int i = 0; i < N; i++)
			count[Integer.parseInt(br.readLine()) - 1]++;
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 10000; i++)
			while(count[i]-- > 0)
			{
				sb.append(i+1);
				sb.append('\n');
			}
		
		System.out.print(sb);	
	}
}
