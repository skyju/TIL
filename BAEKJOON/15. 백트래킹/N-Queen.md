# 문제: 
N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.

N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.

---
# 입력: 
첫째 줄에 N이 주어진다. (1 ≤ N < 15)

---
# 출력: 
첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.

---
# 예제 입력:

예제 입력1
<pre>
8
</pre>

---
# 예제 출력:

예제 출력1
<pre>
92
</pre>

---
# 내 제출
~~~java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int board[];
	static int result;
	static int n;
	
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());

		board = new int[n];

		recursive(0);
		System.out.print(result);
	}

	public static void recursive(int board_index) {

		if (board_index == n) {
			++result;
			return;
		} else {

			for (int v = 0; v < n; v++) {
				if (is_promissing(v, board_index)) {
					board[board_index] = v;
					recursive(board_index + 1);
				}
			}
		}

		return;
	}

	public static boolean is_promissing(int value, int board_index) {

		for (int i = 0; i < board_index; i++) {
			if (value == board[i]
				|| board_index - value == i - board[i]
				|| board_index + value == i + board[i]) {
				return false;
			}
		}
		return true;
	}
}
~~~
