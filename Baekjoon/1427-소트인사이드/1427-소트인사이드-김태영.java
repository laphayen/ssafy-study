import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = sc.next();
    
        System.out.println(strMergeSort(N));
    }

    public static String strMergeSort(String input) {
        if (input.length() == 1) {
            return input;
        }
        String str1 = input.substring(0, (input.length() - 1) / 2 + 1);
        String str2 = input.substring((input.length() - 1) / 2 + 1, input.length());

        return merge(strMergeSort(str1), strMergeSort(str2));
    }

    private static String merge(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        int newStrLength = str1.length() + str2.length();

        int ai = 0, bi = 0;
        for (int i = 0; i < newStrLength; i++) {
            if (str1.charAt(ai) > str2.charAt(bi)) {
                sb.append(str1.charAt(ai++));
                if (ai >= str1.length()) {
                    for (; bi < str2.length(); bi++) {
                        sb.append(str2.charAt(bi));
                    }
                    break;
                }
            } else {
                sb.append(str2.charAt(bi++));
                if (bi >= str2.length()) {
                    for (; ai < str1.length(); ai++) {
                        sb.append(str1.charAt(ai));
                    }
                    break;
                }
            }
        }

        return sb.toString();
    }
}
