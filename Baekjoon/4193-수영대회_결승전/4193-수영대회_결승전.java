import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
 
public class Solution { 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
         
        for(int tc = 1; tc <= T; tc++) {
 
            int N = sc.nextInt();
            int[] dr = {1, 0, -1, 0};
            int[] dc = {0, 1, 0, -1};
            int[][] grid = new int[N][N];
            boolean[][] v = new boolean[N][N];
             
            for(int i = 0; i < N; i++)
                for(int j = 0; j < N; j++)
                    grid[i][j] = sc.nextInt();
             
            int start_r = sc.nextInt(), start_c = sc.nextInt();
            int end_r = sc.nextInt(), end_c = sc.nextInt();
            int ans = -1;
             
            Queue<int[]> q = new ArrayDeque<>();
            q.offer(new int[] {start_r, start_c, 0});
            v[start_r][start_c] = true;
            while(!q.isEmpty()) {
                int[] cur = q.poll();
                int cr = cur[0], cc = cur[1], ct = cur[2];
                if(cr == end_r && cc == end_c) {
                    ans = ct;
                    break;
                }
                     
                for(int d = 0; d < 4; d++) {
                    int nr = cr + dr[d], nc = cc + dc[d];
                    if(OOB(nr, nc, N)) continue;
                    if(v[nr][nc]) continue;
                    if(grid[nr][nc] == 1) continue;
                     
                    if(grid[nr][nc] == 2) {
                        if (ct % 3 == 2) {
                            q.offer(new int[] {nr, nc, ct + 1});
                            v[nr][nc] = true;
                        }
                        else {
                            q.offer(new int[] {cr, cc, ct + 1});
                        }
                    } else {
                        q.offer(new int[] {nr, nc, ct + 1});
                        v[nr][nc] = true;
                    }
                }
            }
             
            System.out.println("#" + tc + " " + ans);
        }
    }
     
    public static boolean OOB(int r, int c, int N) {
        return (r < 0 || r >= N || c < 0 || c >= N);
    }
}