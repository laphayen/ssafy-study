import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		ArrayList<String> arr = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			if (arr.contains(str)) continue;
			arr.add(str);
		}

		Collections.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length()) {
					int len = o1.length();
					for (int i = 0; i < len; i++) {
						if (o1.charAt(i) != o2.charAt(i)) return o1.charAt(i) - o2.charAt(i);
					}
				}
				return o1.length() - o2.length();
			}			
		});
		for (int i = 0; i < arr.size(); i++) sb.append(arr.get(i) + "\n");
		System.out.println(sb.toString());
	}
}
