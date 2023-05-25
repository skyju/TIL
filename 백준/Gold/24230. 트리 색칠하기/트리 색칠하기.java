import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[] color;
    static boolean[] visit;
    static List<Integer>[] list;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        color = new int[N + 1];

        // 인접행렬 선언 및 초기화, 목표 색깔 입력
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            color[i] = Integer.parseInt(st.nextToken());
        }

        // 인접 정보 이어주기
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int first = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());
            list[first].add(last);
            list[last].add(first);
        }

        visit = new boolean[N + 1];
        // 색깔 칠하기
        int result = dfs(1);
        if (color[1] != 0) result++;
        System.out.println(result);
    } // main method

    // 1번인자 : 현재 노드 번호
    // 현재 노드에서 인접한 노드를 반복문으로 돌림
    // 부모 노드의 목표 컬러와 자식 노드의 목표컬러가 다르면 칠해야 하는 횟수를 더하고
    // 자식 노드로부터 dfs 다시 시작
    public static int dfs(int idx) {
        int result = 0;
        int parentColor = color[idx];
        visit[idx] = true;
        int size = list[idx].size();
        for (int i = 0; i < size; i++) {
            if (visit[list[idx].get(i)]) continue;
            if (parentColor != color[list[idx].get(i)]) {
                result++;
            }
            result += dfs(list[idx].get(i));
        }
        return result;
    }

} // class end