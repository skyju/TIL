import java.util.*;

class Solution {
    
    static int min;
    
    private class Node {
        int num, cnt;
        public Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
    public int solution(int x, int y, int n) {
        min = Integer.MAX_VALUE;
        
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(new Node(y, 0));
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (now.num == x) return now.cnt;
            if (now.num > x) {
                if (now.num % 3 == 0) 
                    queue.offer(new Node(now.num / 3, now.cnt + 1));
                if (now.num % 2 == 0)
                    queue.offer(new Node(now.num / 2, now.cnt + 1));
                queue.offer(new Node(now.num - n, now.cnt + 1));
            }
        }
        return -1;
    }
                              
}