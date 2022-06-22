# 문제: 
N+1개의 I와 N개의 O로 이루어져 있으면, I와 O이 교대로 나오는 문자열을 PN이라고 한다.

P1 IOI
P2 IOIOI
P3 IOIOIOI
PN IOIOI...OI (O가 N개)
I와 O로만 이루어진 문자열 S와 정수 N이 주어졌을 때, S안에 PN이 몇 군데 포함되어 있는지 구하는 프로그램을 작성하시오.

---
# 입력: 
첫째 줄에 N이 주어진다. 둘째 줄에는 S의 길이 M이 주어지며, 셋째 줄에 S가 주어진다.

---
# 출력: 
S에 PN이 몇 군데 포함되어 있는지 출력한다.

---
# 예제 입력:

예제 입력1
<pre>
1
13
OOIOIOIOIIOII
</pre>

예제 입력2
<pre>
2
13
OOIOIOIOIIOII
</pre>

---
# 예제 출력:

예제 출력1
<pre>
4
</pre>

예제 출력2
<pre>
2
</pre>

---
# 내 제출

slicing 해서 보면서 연속되게 갯수와 일치하는지 확인하면 됨

~~~java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();
        
        int tmp = 0;
        int ans = 0;
        for (int i = 1; i < M - 1; i++) {
            if (S.substring(i - 1, i + 2).equals("IOI")) {
                tmp++;
                if (tmp == N) {
                    ans++;
                    tmp--;
                }
                i++;
            } else {
                tmp = 0;
            }
        }
        
        System.out.println(ans);
	}
}
~~~

