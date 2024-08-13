import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
public class Solution {
    static int[][] map;
    static boolean[][] v;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt(), K = sc.nextInt();
            List<int[]> high = new ArrayList<>();
            map = new int[N][N];
            v = new boolean[N][N];
            ans = -1;
             
            int mmax = -1;
            for(int i = 0; i < N; i++) 
                for(int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                    mmax = Math.max(mmax, map[i][j]);
                }
 
            for(int i = 0; i < N; i++) 
                for(int j = 0; j < N; j++)
                    if(map[i][j] == mmax)
                        high.add(new int[] {i, j});
             
            for(int i = 0; i < high.size(); i++) {
                int[] cur = high.get(i);
                v[cur[0]][cur[1]] = true;
                solve(N, K, false, cur, 1);
                v[cur[0]][cur[1]] = false;
            }
             
            System.out.println("#" + tc + " " + ans);
        }
    }
     
    public static void solve(int N, int K, boolean used, int[] cur, int step) {
        ans = Math.max(ans, step);
        int chigh = map[cur[0]][cur[1]];
         
        for(int d = 0; d < 4; d++) {
            int nr = cur[0] + dr[d], nc = cur[1] + dc[d];
            int[] nxt = new int[] {nr, nc};
            if(oob(nr, nc, N)) continue;
            if(v[nr][nc]) continue;
            if(map[nr][nc] < chigh) {
                v[nr][nc] = true;
                solve(N, K, used, nxt, step + 1);
                v[nr][nc] = false;
            }
            else if(map[nr][nc] - K < chigh) {
                if(used) continue;
                 
                int tmp = map[nr][nc];
                map[nr][nc] = chigh - 1;
                v[nr][nc] = true;
                solve(N, K, true, nxt, step + 1);
                map[nr][nc] = tmp;
                v[nr][nc] = false;
            }
        }
         
    }
     
    public static boolean oob(int r, int c, int N) {
        return (r < 0 || r >= N || c < 0 || c >= N);
    }
}