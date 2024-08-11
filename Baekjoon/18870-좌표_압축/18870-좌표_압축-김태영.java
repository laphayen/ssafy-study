import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Target[] in = new Target[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            in[i] = new Target(input, i);
        }

        Arrays.sort(in, (o1, o2) -> Integer.compare(o1.val,o2.val));

        int preVal = in[0].val;
        in[0].val = 0;
        for (int i = 1, cnt = 0; i < N; i++) {
            if (preVal != in[i].val) {
                cnt++;
            }
            preVal = in[i].val;
            in[i].val = cnt;
        }

        Arrays.sort(in, (o1, o2) -> Integer.compare(o1.originalIdx, o2.originalIdx));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(in[i].val);
            sb.append(" ");
        }
        System.out.println(sb);
    }

    static class Target {
        int val;
        int originalIdx;

        Target(int val, int originalidx) {
            this.val = val;
            this.originalIdx = originalidx;
        }
    }
}

