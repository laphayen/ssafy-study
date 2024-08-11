import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int D;
    static List<Point> el = new ArrayList();
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                if (Integer.parseInt(st.nextToken()) == 1)
                    el.add(new Point(i, j));
            }
        }

        combination(0, 0, new int[3]);
        System.out.println(max);
    }

    private static void combination(int idx, int k, int[] sel) {
        if (k == 3) {
            List<Point> al = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                al.add(new Point(N, sel[i]));
            }

            max = Math.max(max, run(al));
            return;
        } else if (idx == M) {
            return;
        }

        sel[k] = idx;
        combination(idx + 1, k + 1, sel); //선택한 경우
        combination(idx + 1, k, sel); //선택안할 경우
    }

    private static int run(List<Point> al) {
        List<Point> enemyL = new ArrayList<>(); // 적들의 위치
        Stack<Integer> targetIdxS = new Stack<>(); // 이번 턴에 공격할 적을 저장

        for (int i = 0; i < el.size(); i++) {
            Point p = el.get(i);
            enemyL.add(new Point(p.r, p.c));
        }

        int cnt = 0;
        while (!enemyL.isEmpty()) {
            
            // 공격 대상 선정
            for (int aIdx = 0; aIdx < al.size(); aIdx++) { // 궁수 loop
                Point a = al.get(aIdx); // 궁수 위치
                int tIdx = -1; // 공격할 목표
                int tL = Integer.MAX_VALUE; // 목표까지 거리
                int tC = Integer.MAX_VALUE; // c의 위치
                for (int eIdx = 0; eIdx < enemyL.size(); eIdx++) { // 적 loop 공격 대상을 정함
                    Point e = enemyL.get(eIdx);

                    int eL = (Math.abs(a.r - e.r)) + (Math.abs(a.c - e.c));
                    if (eL <= D) {
                        if (eL < tL) {
                            tIdx = eIdx;
                            tL = eL;
                            tC = e.c;
                        } else if (eL == tL && e.c < tC) {
                            tIdx = eIdx;
                            tC = e.c;
                        }
                    }
                }

                if (tIdx != -1) targetIdxS.push(tIdx);
            }

            // 공격
            while (!targetIdxS.isEmpty()) {
                enemyL.set(targetIdxS.pop(), null); // 적 공격
            }

            // 적 제거 및 이동
            for (int eIdx = 0; eIdx < enemyL.size(); eIdx++) {
                Point ep = enemyL.get(eIdx);
                if (ep == null) { // 적이 공격당한 경우
                    enemyL.remove(eIdx--);
                    cnt++;
                } else {
                    if (++ep.r == N) { // 성에 닿을 경우
                        enemyL.remove(eIdx--);
                    }
                }
            }
        }
        return cnt;
    }

    static class Point {
        int r, c;

        public Point(int r, int c) {
            super();
            this.r = r;
            this.c = c;
        }
    }
}
