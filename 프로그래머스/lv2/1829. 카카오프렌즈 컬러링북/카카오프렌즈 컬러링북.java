import java.util.*;

class Solution {
    
    private class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static int N, M;
    static int numberOfArea, maxSizeOfOneArea;
    static int[][] map;
    
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visit;
    
    public int[] solution(int m, int n, int[][] picture) {
        N = m;
        M = n;
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        visit = new boolean[N][M];
        map = picture;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (picture[i][j] == 0 || visit[i][j]) {
                    continue;
                }
                bfs(i, j);
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public void bfs(int r, int c) {
        Queue<Node> q = new LinkedList<Node>();
        
        int num = map[r][c];
        int cnt = 0;
        visit[r][c] = true;
        q.offer(new Node(r, c));
        
        while(!q.isEmpty()) {
            Node now = q.poll();
            cnt++;
            
            for (int d = 0; d < 4; d++) {
                int nr = now.x + dr[d];
                int nc = now.y + dc[d];
                if (outOfBorder(nr, nc, num)) {
                    continue;
                }
                q.offer(new Node(nr, nc));
                visit[nr][nc] = true;
            }
        }
        
        if (cnt > maxSizeOfOneArea) {
            maxSizeOfOneArea = cnt;
        }
        if (cnt > 0) {
            numberOfArea++;
        }
    }
    
    public boolean outOfBorder(int r, int c, int num) {
        if (r < 0 || c < 0 || r >= N || c >= M || visit[r][c] || map[r][c] != num) {
            return true;
        } else {
            return false;   
        }
    }
}