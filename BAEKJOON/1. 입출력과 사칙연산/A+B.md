# 문제: 
두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

---
# 입력: 
첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)

---
# 출력: 첫째 줄에 A+B를 출력한다.

---
# 예제 입력:

예제 입력1
<pre>
1 2
</pre>

---
# 예제 출력:
<pre>
3</pre>

---
# 내 제출
~~~java
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int A = kb.nextInt();
		int B = kb.nextInt();
		System.out.println(A+B);
	}
}
~~~
