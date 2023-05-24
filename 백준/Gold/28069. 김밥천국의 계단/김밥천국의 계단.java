import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // 계단 개수
        int K = Integer.parseInt(st.nextToken()); // 계단을 오르는 횟수

        int[] dp = new int[1000001];
        for (int i = 0; i < 4; i++) {
            dp[i] = i;
        }
        if (N <= K) {
            System.out.println("minigimbob");
        } else {
            for (int i = 1; i <= N; i++) {
                int prev = (int) Math.ceil(i / 1.5);
                if (prev + (prev / 2) == i) {
                    dp[i] = Math.min(dp[i - 1], dp[prev]) + 1;
                } else {
                    dp[i] = dp[i - 1] + 1;
                }
            }
            if (dp[N] > K || K > N) {
                System.out.println("water");
            } else if (dp[N] <= K) {
                System.out.println("minigimbob");
            }
        }
    }
}