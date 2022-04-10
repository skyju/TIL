# 문제: 
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열

---
# 입력: 
첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

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
4 4
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
1 2
1 3
1 4
2 1
2 3
2 4
3 1
3 2
3 4
4 1
4 2
4 3
</pre>

예제 출력3
<pre>
1 2 3 4
1 2 4 3
1 3 2 4
1 3 4 2
1 4 2 3
1 4 3 2
2 1 3 4
2 1 4 3
2 3 1 4
2 3 4 1
2 4 1 3
2 4 3 1
3 1 2 4
3 1 4 2
3 2 1 4
3 2 4 1
3 4 1 2
3 4 2 1
4 1 2 3
4 1 3 2
4 2 1 3
4 2 3 1
4 3 1 2
4 3 2 1
</pre>

---
# 내 제출

트리 구조를 먼저 생각해서 어떻게 순회하는지 생각
1 -> n 일 때 최대 깊이가 m인 트리~!!
재귀는 깊이기준으로 해야함을 우선 생각
재귀가 멈추는 시점은 depth == m일 때

~~~java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static int arr[];
	static boolean visit[];

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[m];
		visit = new boolean[9];
		
		recursive(0);
	}

	public static void recursive(int depth) {
		if (depth == m) {
			for (int v : arr) {
				System.out.print(v + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (visit[i] == false) {
				visit[i] = true; // 방문
				arr[depth] = i;
				recursive(depth + 1);
				
				// 자식 노드 방문 끝나면 다음 반복을 위해 방문하지 않은 상태로 다시 변경
				visit[i] = false;
			}
		}
		
		return ;
	}
}
~~~
