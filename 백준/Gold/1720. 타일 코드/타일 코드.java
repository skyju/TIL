import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[n + 1];

        dp[0] = 1;
        dp[1] = 1;
        if (n > 1) {
            dp[2] = 3;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 2];
            }
        }
        long ans = 0;
        // 짝수일 때
        if (n == 2) {
            ans = 3;
        } else if (n == 3) {
            ans = 3;
        } else {
            if (n % 2 == 0) {
                // 대칭일 때는 처리해줘야 dp[n / 2 - 1] * 2 부분!!
                ans = (dp[n] + dp[n / 2] + dp[n / 2 - 1] * 2) / 2;
            }
            // 홀수일 때
            else {
                ans = (dp[n] + dp[n / 2]) / 2;
            }
        }
        System.out.println(ans);

    } // main method

} // class end


