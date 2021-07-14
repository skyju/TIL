#문제: 
두 정수 A와 B를 입력받은 다음, A/B를 출력하는 프로그램을 작성하시오.

---
#입력: 
첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)

---
#출력: 
첫째 줄에 A/B를 출력한다. 실제 정답과 출력값의 절대오차 또는 상대오차가 10-9 이하이면 정답이다.

---
#예제 입력:

예제 입력1
<pre>
1 3
</pre>

예제 입력2
<pre>
4 5
</pre>

---
#예제 출력:

예제 출력1
<pre>
0.33333333333333333333333333333333
</pre>

예제 출력2
<pre>
0.8
</pre>

---
# 내 제출
<pre>
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int A = kb.nextInt();
		int B = kb.nextInt();
		double C = A*1.0/B*1.0;
		System.out.println(C);
	}
}
</pre>
