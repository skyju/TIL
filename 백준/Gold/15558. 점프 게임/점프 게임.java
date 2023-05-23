import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, K;
    static char[][] arr;

    static private class Node {
        int time, idx, arrIdx;

        public Node(int time, int idx, int arrIdx) {
            this.time = time;
            this.idx = idx;
            this.arrIdx = arrIdx;
        }

        @Override
        public String toString() {
            return this.time + ", " + this.idx + ", " + this.arrIdx;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // line의 length
        K = Integer.parseInt(st.nextToken());

        arr = new char[2][N];
        arr[0] = br.readLine().toCharArray(); // 왼쪽줄, 왼쪽줄 1번에서 시작
        arr[1] = br.readLine().toCharArray(); // 오른쪽줄

        System.out.println(bfs());

    }

    public static int bfs() {
        boolean[][] visit = new boolean[2][N];
        visit[0][0] = true;

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 0));

        int dc[] = {-1, 1, K};
        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int d = 0; d < 3; d++) {
                int nr = now.arrIdx;
                int nc = now.idx + dc[d];
                if (d == 2) nr = now.arrIdx == 0 ? 1 : 0;
                if (nc >= N) return 1;
                if (nc <= now.time || visit[nr][nc] || arr[nr][nc] == '0') continue;
                visit[nr][nc] = true;
                q.offer(new Node(now.time + 1, nc, nr));
            }
        }
        return 0;
    }

}