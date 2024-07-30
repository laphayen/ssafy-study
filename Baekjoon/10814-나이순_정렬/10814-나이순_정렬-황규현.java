import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Pair {
	int age;
	String name;
	
	Pair(int age, String name) {
		this.age = age;
		this.name = name;
	}
}
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		ArrayList<Pair> arr = new ArrayList<Pair>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr.add(new Pair(Integer.parseInt(st.nextToken()), st.nextToken()));
		}

		Collections.sort(arr, new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.age - o2.age;
			}			
		});
		for (int i = 0; i < arr.size(); i++) sb.append(arr.get(i).age + " " + arr.get(i).name + "\n");
		System.out.println(sb.toString());
	}
}
