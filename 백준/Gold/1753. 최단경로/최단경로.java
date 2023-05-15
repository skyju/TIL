import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int V, E, start;
    static List<Node>[] list;

    static class Node implements Comparable<Node> {
        int to, weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken()); // Vertex Num
        E = Integer.parseInt(st.nextToken()); // Edge Num
        start = Integer.parseInt(br.readLine());

        // 리스트 초기화
        list = new LinkedList[V + 1];
        for (int i = 0; i < V + 1; i++) {
            list[i] = new LinkedList<>();
        }

        // 간선정보
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to, weight));
        }
        bfs();
    }

    public static void bfs() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        int[] ans = new int[V + 1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            for (Node node : list[now.to]) {
                // 갱신이 필요한 상황
                if (ans[node.to] > now.weight + node.weight) {
                    ans[node.to] = now.weight + node.weight;
                    pq.offer(new Node(node.to, ans[node.to]));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < ans.length; i++) {
            if (ans[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            } else {
                sb.append(ans[i] + "\n");
            }
        }
        System.out.print(sb.toString());
    }
}