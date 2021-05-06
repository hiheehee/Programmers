import java.util.PriorityQueue;

public class PROGRAMMERS1844 {
	static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static int w, h;
    static int answer = Integer.MAX_VALUE;
    
    public static void main(String[] args) {
    	int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        w = maps.length;
        h = maps[0].length;
        
        bfs(maps);
        if(answer == Integer.MAX_VALUE) answer = -1;
        System.out.print(answer);
    }
    
    static void bfs(int[][] maps){
        PriorityQueue<coordinate> q = new PriorityQueue<>();
        boolean visited[][] = new boolean[w][h];
        q.offer(new coordinate(0,0,1));
        visited[0][0] = true;
        while(!q.isEmpty()){
            coordinate cur = q.poll();
            
            if(cur.x == w-1 && cur.y == h-1){
                answer = Math.min(answer, cur.count);
                return;
            }
            
            for(int i = 0; i < 4; i++){
                int tx = cur.x + dx[i];
                int ty = cur.y + dy[i];
                
                if(tx < 0 || w <= tx || ty < 0 || h <= ty) continue;
                if(visited[tx][ty] || maps[tx][ty] == 0) continue;
                
                q.offer(new coordinate(tx,ty, cur.count+1));
                visited[tx][ty] = true;
            }
        }
    }
    
    static class coordinate implements Comparable<coordinate>{
        int x;
        int y;
        int count;
        
        coordinate(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
        
        @Override public int compareTo(coordinate o) {
            return this.count - o.count; 
        }
    }
}