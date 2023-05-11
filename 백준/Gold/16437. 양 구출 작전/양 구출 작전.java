import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static int N;
    static List<Integer>[] list;
    static int[] animals;
    static long[] nums;

    // W: wolf
    // S: sheep
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        animals = new int[N + 1];
        nums = new long[N + 1];

        // 리스트 초기화
        list = new LinkedList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new LinkedList<Integer>();
        }

        // 입력받기
        for (int i = 2; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            char c = st.nextToken().charAt(0);
            long num = Long.parseLong(st.nextToken());
            int island = Integer.parseInt(st.nextToken());
            animals[i] = c;
            nums[i] = num;
            list[island].add(i);
        }

        System.out.println(dfs(1));
    }

    public static long dfs(int node) {
        long sum = 0;

        // 자식노드로 타고 들어감
        for (int i : list[node]) {
            sum += dfs(i);
        }

        if (animals[node] == 'S') sum += nums[node];
        else sum -= nums[node];
        if (sum < 0) return 0;

        return sum;
    }
}