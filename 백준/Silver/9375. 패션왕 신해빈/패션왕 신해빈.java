import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < num; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                String cloth = st.nextToken();
                String type = st.nextToken();
                if (map.containsKey(type)) {
                    map.put(type, map.get(type) + 1);
                } else {
                    map.put(type, 1);
                }
            }
            Iterator iter = map.values().iterator();
            int result = 1;
            while (iter.hasNext()) {
                int n = (int) iter.next() + 1;
                result *= n;
            }
            System.out.println(result - 1);

        }
    } // main method


} // class end


