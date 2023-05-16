import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        //N개의 동전으로 K원을 만드는 경우의 수, 순서는 상관없음 (조합)

        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[k + 1];

        // 0 원을 만드는 경우 : 아무것도 선택하지 않는 경우의 수 1
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            // coin을 가지고 1원부터 k원까지 만드는 경우의 수 계산
            for (int target = 1; target <= k; target++) {
                // coin이 만들려고 하는 목표보다 작거나 같으면 점화식 사용
                if (target >= coin[i])
                    dp[target] += dp[target - coin[i]];
            }
        }
        System.out.println(dp[k]);

    }


}