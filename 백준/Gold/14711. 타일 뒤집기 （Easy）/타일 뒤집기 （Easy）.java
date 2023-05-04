import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static char[][] map;

    // 아이디어: 인접한 #의 갯수를 센다.
    // 해당 칸이 #이면 짝수일때 반전, .이면 홀수일때 반전한다.
    // 위부터 채우니까 아래는 볼필요가 없다.
    static int[] dr = {-1, 0, 0};
    static int[] dc = {0, -1, 1};
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        map[0] = br.readLine().toCharArray();

        for (int r = 0; r < N - 1; r++) {
            for (int c = 0; c < N; c++) {
                // 인접한 #의 개수를 세자
                int cnt = 0;
                for (int d = 0; d < 3; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (outBoundery(nr, nc)) continue;
                    if (map[nr][nc] == '#') cnt++;
                }
                char cha = map[r][c];
                map[r + 1][c] = cnt % 2 == 0 ? '.' : '#';
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(map[i]);
            sb.append('\n');
        }
        System.out.println(sb.toString());

    }

    public static boolean outBoundery(int r, int c) {
        if (r < 0 || c < 0 || r >= N || c >= N) return true;
        return false;
    }
}
