import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        Subway stations = new Subway();
        int prev = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            stations.addStation(prev, temp);
            prev = temp;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String work = st.nextToken();
            int temp = Integer.parseInt(st.nextToken());

            switch (work) {
                case "BN":
                    sb.append(stations.next[temp]).append('\n');
                    stations.addStation(temp, Integer.parseInt(st.nextToken()));
                    break;
                case "BP":
                    sb.append(stations.prev[temp]).append('\n');
                    stations.addStation(stations.prev[temp], Integer.parseInt(st.nextToken()));
                    break;
                case "CN":
                    sb.append(stations.next[temp]).append('\n');
                    stations.removeStation(stations.next[temp]);
                    break;
                case "CP":
                    sb.append(stations.prev[temp]).append('\n');
                    stations.removeStation(stations.prev[temp]);
                    break;
            }
        }

        System.out.print(sb);
    }

    static class Subway {
        int[] prev = new int[1000001];
        int[] next = new int[1000001];

        void addStation(int prev, int newStation) {
            if (prev == 0) {
                this.prev[newStation] = newStation;
                this.next[newStation] = newStation;
                return;
            }
            this.prev[newStation] = prev;
            this.next[newStation] = next[prev];
            this.prev[next[prev]] = newStation;
            this.next[prev] = newStation;
        }

        void removeStation(int target) {
            this.prev[this.next[target]] = this.prev[target];
            this.next[this.prev[target]] = this.next[target];
        }
    }
}
