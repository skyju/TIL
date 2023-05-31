import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] hubo;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        hubo = new int[N];

        // list에 각 중복이 없는 값의 가장 왼쪽 idx를 저장합니다.
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            hubo[i] = Integer.parseInt(st.nextToken());
            if (i == 0 || hubo[i] > hubo[i - 1]) list.add(i);
        }

        int left = 0;
        int right = list.size() - 1;

        StringBuilder sb = new StringBuilder();
        // 배열의 모든 값이 다 같은 경우
        if (hubo.length > 1 && list.size() == 1) {
            System.out.println(-1);
        } else {
            // 이분탐색을 진행합니다.
            while (left + 1 < right) {
                int mid = (left + right) / 2;
                if (canChampion(list.get(mid))) right = mid;
                else left = mid;
            }
            for (int idx : list) {
                if (idx >= list.get(right)) {
                    sb.append(idx + 1).append(" ");
                }
            }
        }
        System.out.println(sb.toString().trim());
    } // main method

    // 챔피언이 될 수 있는지 확인
    static boolean canChampion(int i) {
        int now = i;
        int power = hubo[i];
        while (now - 1 >= 0 && power > hubo[now - 1]) {
            power++;
            now--;
        }
        // 왼쪽도 다 못이기면 가망X
        if (now != 0) return false;
        now = i;
        while (now + 1 < N && power > hubo[now + 1]) {
            power++;
            now++;
        }
        // 다음으로 최대로 세진 상태에서 오른쪽 다 못이기면 실패
        if (now != N - 1) return false;
        return true;
    }

} // class end


