import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, K, result;
    static char[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Node {
        int x, y, time;
        int key;

        public Node(int x, int y, int time, int key) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.key = key;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        result = -1;
        bfs();
        System.out.println(result);
    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();
        boolean[][][] visit = new boolean[N][M][K + 1];

        // [0] 안뿌수고 왔을 때 최단거리
        // [1] 뿌수고 왔을 때 최단거리


        q.offer(new Node(0, 0, 1, 0));
        visit[0][0][0] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();
            // 목적지에 도달했으면 끝
            if (now.x == N - 1 && now.y == M - 1) {
                result = now.time;
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = now.x + dr[d];
                int nc = now.y + dc[d];
                if (!outOfBorder(nr, nc)) continue;

                if (map[nr][nc] == '0') {
                    if (visit[nr][nc][now.key]) continue;
                    visit[nr][nc][now.key] = true;
                    q.add(new Node(nr, nc, now.time + 1, now.key));
                } else {
                    if (visit[nr][nc][now.key] || K <= now.key) continue;
                    visit[nr][nc][now.key] = true;
                    q.add(new Node(nr, nc, now.time + 1, now.key + 1));
                }
            }
        }
    }

    public static boolean outOfBorder(int nr, int nc) {
        if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
            return false;
        }
        return true;
    }
}