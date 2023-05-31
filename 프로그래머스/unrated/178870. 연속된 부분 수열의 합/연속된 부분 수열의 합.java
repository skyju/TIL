import java.util.*;

class Solution {
    
    private class Result implements Comparable<Result> {
        int start, end, size;
        public Result(int start, int end) {
            this.start = start;
            this.end = end;
            this.size = end - start;
        }
        @Override
        public int compareTo(Result o) {
            if (this.size == o.size) {
                return this.start - o.start;
            }
            return this.size - o.size;
        }
    }
    
    public int[] solution(int[] sequence, int k) {
        
        int start = 0;
        int end = 0;
        int len = sequence.length;
        List<Result> list = new ArrayList<Result>();

        int sum = sequence[0];
        while (true) {
            if (sum == k) {
                list.add(new Result(start, end));
            }
            if (start == len && end == len) break;
            if (sum <= k && end < len) {
                end++;
                if (end < len) sum += sequence[end];
            } else {
                sum -= sequence[start];
                start++;
            }
        }
        Collections.sort(list) ;
        Result result = list.get(0);
        return new int[] {result.start, result.end};
    }
}