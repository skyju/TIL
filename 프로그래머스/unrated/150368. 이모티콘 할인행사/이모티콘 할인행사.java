import java.util.*;

class Solution {
    
    static int emoCnt, plusCnt, totalSum;
    static int[] result, emoticon;
    static int[][] user;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        
        emoCnt = emoticons.length;
        result = new int[emoCnt];
        emoticon = emoticons;
        user = users;
        dfs(0);
        answer[0] = plusCnt;
        answer[1] = totalSum;
        
        return answer;
    }
    
    public void dfs(int cnt) {
        if (cnt == emoCnt) {
            
            int plusCntTmp = 0;
            int totalSumTmp = 0;
            for (int i = 0; i < user.length; i++) {
                int percent = user[i][0];
                int limit = user[i][1];
                
                int sum = 0;
                for (int j = 0; j < emoCnt; j++) {
                    if (percent <= result[j]) {
                        sum += emoticon[j] - (emoticon[j] * result[j] / 100);
                    }
                }
                if (sum >= limit) {
                    plusCntTmp++;
                } else {
                    totalSumTmp += sum;
                }
            }
            if (plusCnt <= plusCntTmp) {
                if (plusCnt < plusCntTmp) {
                    plusCnt = plusCntTmp;
                    totalSum = totalSumTmp;
                } else {
                    totalSum = Math.max(totalSum, totalSumTmp);
                }
            }
            return;
        }
        
        for (int i = 10; i <= 40; i+= 10) {
            result[cnt] = i;
            dfs(cnt + 1);
        }
    }
}