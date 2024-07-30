aimport java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());


        Point[] ps = new Point[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            ps[i] = new Point();
            ps[i].x = Integer.parseInt(st.nextToken());
            ps[i].y = Integer.parseInt(st.nextToken());
        }

        ps = mergeSort(ps);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ps.length; i++) {
            sb.append(ps[i].x);
            sb.append(" ");
            sb.append(ps[i].y);
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

    public static Point[] mergeSort(Point[] input) {
        if (input.length == 1) {
            return input;
        }

        Point[] a = new Point[input.length / 2];
        System.arraycopy(input, 0, a, 0, input.length / 2);

        Point[] b = new Point[input.length - (input.length / 2)];
        System.arraycopy(input, input.length / 2, b, 0, input.length - (input.length / 2));

        return merge(mergeSort(a), mergeSort(b));
    }

    private static Point[] merge(Point[] a, Point[] b) {
        Point[] newP = new Point[a.length + b.length];

        int ai = 0, bi = 0;
        for (int i = 0; i < newP.length; i++) {
            if (ai >= a.length) {
                newP[i] = b[bi++];
                continue;
            }

            if (bi >= b.length) {
                newP[i] = a[ai++];
                continue;
            }

            
            if (a[ai].x < b[bi].x) {
                newP[i] = a[ai++];
            } else if (b[bi].x < a[ai].x) {
                newP[i] = b[bi++];
            } else {
                if (a[ai].y < b[bi].y) {
                    newP[i] = a[ai++];
                } else {
                    newP[i] = b[bi++];
                }
            }
        }
        return newP;
    }
    
    static class Point {
        int x;
        int y;
    }
}


