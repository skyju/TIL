import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<int[]> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            stack.push(new int[]{i, Integer.parseInt(st.nextToken())});
        }

        int[] result = new int[N];
        Stack<int[]> waiting = new Stack<>();
        while (!stack.isEmpty()) {
            int[] now = stack.pop();
            if (!stack.isEmpty()) {
                int[] peek = stack.peek();
                if (peek[1] > now[1]) {
                    result[now[0] - 1] = peek[0];
                } else {
                    waiting.push(now);
                }
                while (!waiting.isEmpty() && peek[1] > waiting.peek()[1]) {
                    result[waiting.peek()[0] - 1] = peek[0];
                    waiting.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
    } // main method

} // class end

//  10
//  8 7 5 8 6 5 2 4 4 9
//        9pop->4peek가 크지않음->다른 큐에 9push
//        4pop,9peek->4peek가 크지않음->다른 큐에 4push
//        4pop,4peek->2peek가 크지않음->다른 큐에 4push
//        2pop 4peek->5peek가 큼->2,4해결 4pop
//        5pop 9peek->6peek가 큼->5해결
//        6pop 9peek->8peek가 큼->6해결
//        8pop 9peek->5peek가 크지않음->다른 큐에 8push
//        5pop 8peek->7peek가 큼->5해결
//        7pop 8peek->8peek가 큼->7pop 해결


