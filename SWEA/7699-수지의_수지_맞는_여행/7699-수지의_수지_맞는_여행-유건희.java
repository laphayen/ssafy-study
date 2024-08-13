import java.util.Scanner;
 
public class Solution {
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int[][] map;
    static boolean[] v;
    static int ans;
    static int R, C;
     
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
         
        for(int tc = 1; tc <= T; tc++) {
            R = sc.nextInt(); C = sc.nextInt();
            map = new int[R][C];
            v = new boolean[26];
            ans = 0;
             
            for (int i = 0; i < R; i++) {
                String line = sc.next();
                for (int j = 0; j < C; j++)
                    map[i][j] = line.charAt(j) - 'A'; 
            }
             
            v[map[0][0]] = true;
            solve(0, 0, 1);
            System.out.println("#" + tc + " " + ans);
        }
    }
     
    public static void solve(int r, int c, int step) {
        ans = Math.max(ans, step);
         
        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d], nc = c + dc[d];
            if(oob(nr, nc)) continue;
            if(v[map[nr][nc]]) continue;
             
            v[map[nr][nc]] = true;
            solve(nr, nc, step + 1);
            v[map[nr][nc]] = false;
        }
    }
     
    public static boolean oob(int r, int c) {
        return (r < 0 || r >= R || c < 0 || c >= C);
    }
}