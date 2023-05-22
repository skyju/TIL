import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static char[][] map;
    static int[] dr = {-1, 1, 0, 0, 1, -1, -1, 1};
    static int[] dc = {0, 0, -1, 1, 1, -1, 1, -1};

    // 모래성 위주 -> 모래성이 아닌거 위주로 생각을 바꿔야..

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '.') {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int result = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] now = q.poll();

                for (int d = 0; d < 8; d++) {
                    int nr = now[0] + dr[d];
                    int nc = now[1] + dc[d];
                    if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                        continue;
                    }
                    if (map[nr][nc] != '.') {
                        map[nr][nc]--;
                        // 완전히 깎여서 모래가 된 경우
                        if (map[nr][nc] == '0') {
                            map[nr][nc] = '.';
                            q.offer(new int[]{nr, nc});
                        }
                    }
                }
            } // for end
            result++;
        } // while end
        System.out.println(result - 1);
    }
}