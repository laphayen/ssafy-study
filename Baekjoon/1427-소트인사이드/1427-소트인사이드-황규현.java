import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String n = br.readLine();
		int[] arr = new int[n.length()];
		for (int i = 0; i < n.length(); i++) {
			arr[i] = n.charAt(i) - '0';
		}

		Arrays.sort(arr);
		for (int i = n.length()-1; i >= 0; i--) sb.append(arr[i]);
		System.out.println(sb.toString());
	}
}
