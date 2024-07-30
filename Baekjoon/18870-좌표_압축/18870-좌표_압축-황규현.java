import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[n], ans = new int[n];
		Map<Integer, Integer> m = new HashMap<>();
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			ans[i] = arr[i];
		}
		Arrays.sort(arr);
		for (int i = 0, val = 0; i < n; i++) {
			if (i > 0 && arr[i] > arr[i-1]) m.put(arr[i], ++val);
			m.put(arr[i], val);
		}
		for (int i = 0; i < n; i++) sb.append(m.get(ans[i]) + " ");
		System.out.println(sb.toString());
	}
}
