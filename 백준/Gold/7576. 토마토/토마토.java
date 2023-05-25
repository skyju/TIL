import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        // 1 : 익은 토마토
        // 0 : 익지 않은 토마토
        // -1: 토마토 없음


        map = new int[N][M];
        int count = 0;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    count++;
                } else if (map[i][j] == 1) {
                    q.offer(new int[]{i, j, 0});
                    visit[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (map[now[0]][now[1]] == 0) {
                map[now[0]][now[1]] = 1;
                count--;
            }

            if (count == 0) {
                System.out.println(now[2]);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = now[0] + dr[d];
                int nc = now[1] + dc[d];
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if (visit[nr][nc] || map[nr][nc] == -1) continue;
                if (map[nr][nc] == 0) {
                    visit[nr][nc] = true;
                    q.offer(new int[]{nr, nc, now[2] + 1});
                }
            }
        }
        System.out.println(-1);

    } // main method

} // class end