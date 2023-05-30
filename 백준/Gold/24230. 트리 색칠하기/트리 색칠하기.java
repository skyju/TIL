import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] color;
    static boolean[] visit;
    static List<Integer>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        color = new int[N + 1];
        list = new ArrayList[N + 1];
        visit = new boolean[N + 1];

        // 목표 색깔 정보 입력 및 인접행렬 초기화
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            color[i] = Integer.parseInt(st.nextToken());
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int first = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());
            list[first].add(last);
            list[last].add(first);
        }
        int result = dfs(1);
        if (color[1] != 0) result++;
        System.out.println(result);
    } // main method

    public static int dfs(int node) {
        int result = 0;
        visit[node] = true;
        int size = list[node].size();
        for (int i = 0; i < size; i++) {
            if (visit[list[node].get(i)]) continue;
            // 부모와 목표 색깔이 다르면
            if (color[node] != color[list[node].get(i)]) {
                result++;
            }
            // 그의 자식까지 탐색한 후 색칠
            result += dfs(list[node].get(i));
        }
        return result;
    }

} // class end


