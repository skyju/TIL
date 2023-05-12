import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, M;
    // 0,1,2는 연료소모 없이 갈 수 있다.
    static int[] dr = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int[] dc = {1, 1, 1, 0, -1, -1, -1, 0};

    private static class Node implements Comparable<Node> {
        int x, y, energy;

        public Node(int x, int y, int energy) {
            this.x = x;
            this.y = y;
            this.energy = energy;
        }

        @Override
        public int compareTo(Node o) {
            return this.energy - o.energy;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Node start = null;
        char[][] map = new char[N][M];
        int[][] dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'K') {
                    start = new Node(i, j, 0);
                }
            }
        }

        int result = -1;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(start);

        // dp 배열 초기화
        dp[start.x][start.y] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            // 종료
            if (map[now.x][now.y] == '*') {
                result = now.energy;
                break;
            }
            if (dp[now.x][now.y] < now.energy) continue;

            for (int d = 0; d < 8; d++) {
                int nr = now.x + dr[d];
                int nc = now.y + dc[d];

                if (isOutborder(nr, nc) || map[nr][nc] == '#') continue;
                int newEnergy = now.energy + (d < 3 ? 0 : 1);
                if (dp[nr][nc] <= newEnergy) continue;

                pq.offer(new Node(nr, nc, newEnergy));
                dp[nr][nc] = newEnergy;
            }
        }
        System.out.println(result);
    }

    public static boolean isOutborder(int nr, int nc) {
        if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
            return true;
        }
        return false;
    }
}