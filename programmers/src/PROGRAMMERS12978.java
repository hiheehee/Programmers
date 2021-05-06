import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class PROGRAMMERS12978 {
	
    static ArrayList<edge>[] al;
    static int town[];
    static boolean visited[];
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        al = new ArrayList[N+1];
        town = new int[N+1];
        visited = new boolean[N+1];
        
        for(int i = 0; i < N+1; i++) al[i] = new ArrayList<>();
        
        for(int i = 0; i < road.length; i++){
            al[road[i][0]].add(new edge(road[i][1], road[i][2]));
            al[road[i][1]].add(new edge(road[i][0], road[i][2]));
        }
        
        bfs();
        
        for(int i = 1; i < N+1; i++){
            if(town[i] <= K){
                answer++;
            }
        }
        
        return answer;
    }
    
    static void bfs(){
        PriorityQueue<edge> pq = new PriorityQueue<>();
        pq.offer(new edge(1, 0));
        Arrays.fill(town, Integer.MAX_VALUE);
        
        while(!pq.isEmpty()){
            edge cur = pq.poll();
            
            visited[cur.n] = true;
            town[cur.n] = Math.min(town[cur.n], cur.w);
            
            for(edge i: al[cur.n]){
                if(!visited[i.n]){
                    pq.offer(new edge(i.n, cur.w+i.w));
                }
            }
        }
    }
    
    static class edge implements Comparable<edge>{
        int n;
        int w;
        
        edge(int n, int w){
            this.n = n;
            this.w = w;
        }
        
        // 가중치 오름차순으로 정렬 
        @Override 
        public int compareTo(edge o) { 
            return this.w - o.w; 
        }
    }
}