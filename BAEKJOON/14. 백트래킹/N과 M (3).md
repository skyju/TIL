# 문제: 
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

1부터 N까지 자연수 중에서 M개를 고른 수열
같은 수를 여러 번 골라도 된다.

---
# 입력: 
첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 7)

---
# 출력: 
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.

---
# 예제 입력:

예제 입력1
<pre>
3 1
</pre>

예제 입력2
<pre>
4 2
</pre>

예제 입력3
<pre>
3 3
</pre>

---
# 예제 출력:

예제 출력1
<pre>
1
2
3
</pre>

예제 출력2
<pre>
1 1
1 2
1 3
1 4
2 1
2 2
2 3
2 4
3 1
3 2
3 3
3 4
4 1
4 2
4 3
4 4
</pre>

예제 출력3
<pre>
1 1 1
1 1 2
1 1 3
1 2 1
1 2 2
1 2 3
1 3 1
1 3 2
1 3 3
2 1 1
2 1 2
2 1 3
2 2 1
2 2 2
2 2 3
2 3 1
2 3 2
2 3 3
3 1 1
3 1 2
3 1 3
3 2 1
3 2 2
3 2 3
3 3 1
3 3 2
3 3 3
</pre>

---
# 내 제출

~~~java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int arr[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[m];

		recursive(0);
		System.out.print(sb);
	}

	public static void recursive(int depth) {
		if (depth == m) {
			for (int v : arr) {
				sb.append(v + " ");
			}
			sb.append('\n');
			return;
		}

		for (int i = 1; i <= n; i++) {
			arr[depth] = i;
			recursive(depth + 1);
		}
		return;
	}

}
~~~
