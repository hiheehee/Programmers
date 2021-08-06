import java.util.ArrayList;
import java.util.PriorityQueue;


public class PROGRAMMERS81302 {

	static int dxy[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) {
		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		int[] answer = new int[5];
        
		for(int i = 0; i < 5; i++)
        	answer[i] = 1;
		
        for(int i = 0; i < 5; i++){
        	char map[][] = makeMap(places[i]);
            ArrayList<coordinate> people = count(map);
            for(int j = 0; j < people.size(); j++){
                if(bfs(people.get(j), map)) { // 거리두기 잘 지키지 않았을 경우 true
                	answer[i] = 0; 
                	break;
                }
            }
            
        }
        
        for(int i:answer) {
        	System.out.println(i);
        }
        //return answer;
    }
    
    static ArrayList<coordinate> count(char map[][]){
        ArrayList<coordinate> people = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(map[i][j]== 'P'){
                    people.add(new coordinate(i, j, 0));
                }
            }
        }
        return people;
    }
    
    static char[][] makeMap(String[] places) {
    	char map[][] = new char[5][5];
        for(int i = 0; i < 5; i++){
            map[i] = places[i].toCharArray();
        }
        return map;
    }
    
    static boolean bfs(coordinate person, char map[][]) {
        PriorityQueue<coordinate> q = new PriorityQueue<>();
        q.add(person);
        boolean visited[][] = new boolean[5][5];

        while(!q.isEmpty()) {
        	coordinate cur = q.poll();
        	if(2 <= cur.count) continue; // 거리가 2보다 크면 더 갈필요 없음
        	if(visited[cur.x][cur.y]) continue;
        	visited[cur.x][cur.y] = true;
        	
        	for(int i = 0; i < 4; i++) {
        		int tx = cur.x + dxy[i][0];
        		int ty = cur.y + dxy[i][1];
        		if(!isRange(tx,ty)) continue; // 범위 초과면 pass
        		if(visited[tx][ty]) continue; 
        		if(map[tx][ty] == 'O') {
        			q.add(new coordinate(tx, ty, cur.count+1));
        		}else if(map[tx][ty] == 'P') {
        			if(cur.count+1 <= 2) return true; // 거리 2이하에 사람있으면 return true
        		}
        	}
        }
        return false;
    }
    
    static boolean isRange(int x, int y) {
    	return 0 <= x && x < 5 && 0 <= y && y < 5;
    }
    
    static class coordinate implements Comparable<coordinate>{
        int x;
        int y;
        int count;
        
        public coordinate(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

		@Override
		public int compareTo(coordinate o) {
			return this.count - o.count;
		}
    }
}
