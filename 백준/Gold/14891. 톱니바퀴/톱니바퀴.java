import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static char[][] circle;

    static class Point {
        int idx, dir;

        public Point(int idx, int dir) {
            this.idx = idx;
            this.dir = dir;
        }

        @Override
        public String toString() {
            return this.idx + ", " + this.dir;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        circle = new char[4][8];
        for (int i = 0; i < 4; i++) {
            circle[i] = br.readLine().toCharArray();
        }

        // 회전 명령
        // 맞닿은 부분
        // 0 : 2 <-> 1: 6
        // 1: 2 <-> 2: 6
        // 2 : 2 <-> 3: 6
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int idx = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());

            List<Point> list = new ArrayList<>();
            list.add(new Point(idx, dir));
            int tmp = dir;
            // 해당 지점 뒤
            for (int j = idx; j < 3; j++) {
                if (circle[j][2] != circle[j + 1][6]) {
                    tmp = tmp == 1 ? -1 : 1;
                    list.add(new Point(j + 1, tmp));
                } else {
                    break;
                }
            }
            tmp = dir;
            // 해당 지점 앞
            for (int j = idx; j > 0; j--) {
                if (circle[j - 1][2] != circle[j][6]) {
                    tmp = tmp == 1 ? -1 : 1;
                    list.add(new Point(j - 1, tmp));
                } else {
                    break;
                }
            }
            for (int j = 0; j < list.size(); j++) {
                Point point = list.get(j);
                rotate(point.idx, point.dir);
            }
        }
        int result = 0;
        if (circle[0][0] == '1') {
            result += 1;
        }
        if (circle[1][0] == '1') {
            result += 2;
        }
        if (circle[2][0] == '1') {
            result += 4;
        }
        if (circle[3][0] == '1') {
            result += 8;
        }
        System.out.println(result);
    } // main method

    public static void rotate(int idx, int dir) {
        // 시계 방향
        if (dir == 1) {
            char[] tmp = new char[8];
            tmp[0] = circle[idx][7];
            for (int i = 1; i < 8; i++) {
                tmp[i] = circle[idx][i - 1];
            }
            circle[idx] = tmp;
        }
        // 반 시계 방향
        else {
            char[] tmp = new char[8];
            tmp[7] = circle[idx][0];
            for (int i = 0; i < 7; i++) {
                tmp[i] = circle[idx][i + 1];
            }
            circle[idx] = tmp;
        }
    }
} // class end


