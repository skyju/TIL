https://www.acmicpc.net/problem/10757

# 문제: 
두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

---
# 입력: 
첫째 줄에 A와 B가 주어진다. (0 < A,B < 1010000)

---
# 출력: 
첫째 줄에 A+B를 출력한다.

---
# 예제 입력:

예제 입력1
<pre>
9223372036854775807 9223372036854775808
</pre>

---
# 예제 출력:

예제 출력1
<pre>
18446744073709551615
</pre>

---
# 내 제출

~~~java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		BigInteger A = new BigInteger(st.nextToken());
		BigInteger B = new BigInteger(st.nextToken());
		
		A = A.add(B);
		
		System.out.println(A.toString());
		
	}
}
~~~
