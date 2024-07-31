import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] strs = new String[N];
        for (int i = 0; i < N; i++) {
            strs[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();
        for (String str : mergeSort(strs)) {
            sb.append(str);
            sb.append("\n");
        }
        
        System.out.println(sb);
    }

    public static String[] mergeSort(String[] input) {
        if (input.length == 1) {
            return input;
        }

        String[] lArr = new String[input.length / 2];
        System.arraycopy(input, 0, lArr, 0, input.length / 2);
        String[] rArr = new String[input.length - (input.length / 2)];
        System.arraycopy(input, input.length / 2, rArr, 0, input.length - (input.length / 2));

        return merge(mergeSort(lArr), mergeSort(rArr));
    }

    private static String[] merge(String[] lArr, String[] rArr) {
        Queue<String> nQueue = new ArrayDeque<String>();

        int li = 0, ri = 0;
        while(true) {
            if (li == lArr.length) {
                while (ri < rArr.length) {
                    nQueue.offer(rArr[ri++]);
                }
                break;
            } else if (ri == rArr.length) {
                while (li < lArr.length) {
                    nQueue.offer(lArr[li++]);
                }
                break;
            }

            if (lArr[li].length() > rArr[ri].length()) {
                nQueue.offer(rArr[ri++]);
            } else if (lArr[li].length() < rArr[ri].length()) {
                nQueue.offer(lArr[li++]);
            } else {
                int cmpR = lArr[li].compareTo(rArr[ri]);
                if (cmpR < 0) {
                    nQueue.offer(lArr[li++]);
                } else if (cmpR > 0) {
                    nQueue.offer(rArr[ri++]);
                } else {
                    li++;
                }
            }
        }

        String[] nArr = new String[nQueue.size()];
        nArr = nQueue.toArray(nArr);
        return nArr;
    }
}
