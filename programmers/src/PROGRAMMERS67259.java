import java.util.PriorityQueue;

public class PROGRAMMERS67259 {
	static int n;
	static boolean visited[][][];
	static int dxy[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	static int answer = Integer.MAX_VALUE;
    
    public int solution(int[][] board) {
        n = board.length;

        visited = new boolean[n][n][4];
        bfs(new coordinate(0,0,0,0), board);
        visited = new boolean[n][n][4];
        bfs(new coordinate(0,0,1,0), board);
        visited = new boolean[n][n][4];
        bfs(new coordinate(0,0,2,0), board);
        visited = new boolean[n][n][4];
        bfs(new coordinate(0,0,3,0), board);
        
        
        return answer;
    }
    
    static void bfs(coordinate init, int[][] board) {
		PriorityQueue<coordinate> pq = new PriorityQueue<>();
		pq.add(init);

		while(!pq.isEmpty()) {
			coordinate cur= pq.poll();
			if(cur.x == n-1 && cur.y == n-1) {
				answer = Math.min(answer, cur.cost);
				return;
			}
			if(visited[cur.x][cur.y][cur.dir]) continue;
			visited[cur.x][cur.y][cur.dir] = true;
			for(int i = 0; i < 4; i++) {
				int tx = cur.x + dxy[i][0];
				int ty = cur.y + dxy[i][1];
				if(!isRange(tx, ty)) continue;
				if(board[tx][ty] == 1) continue;
				if(cur.dir == i) {
					pq.add(new coordinate(tx, ty, i, cur.cost+100));
				}else {
					pq.add(new coordinate(tx, ty, i, cur.cost+600));
				}

			}
		}
	}
	
	static boolean isRange(int x, int y) {
		return -1 < x && x < n && -1 < y && y < n;
 	}
	      
	static class coordinate implements Comparable<coordinate>{
		int x;
		int y;
		int cost;
		int dir;
		
		coordinate(int x, int y, int dir, int cost) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cost = cost;
		}

		@Override
		public int compareTo(coordinate o) {
			return this.cost - o.cost;
		}
	}
}