public class PROGRAMMERS77485 {
	static int map[][];
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        map = new int[rows][columns];
        int count = 1;
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                map[i][j] = count;
                count++;
            }
        }
            
        for(int i = 0; i < queries.length; i++){
            answer[i] = rotation(queries[i][0]-1, queries[i][1]-1, queries[i][2]-1, queries[i][3]-1);
        }

        return answer;
    }
    
    static int rotation(int sx, int sy, int ex, int ey) {
        int min = Integer.MAX_VALUE;
        int next = 0;
        int before = 0;
        
        // 왼
        next = map[sx][ey];
        for(int i = ey; i > sy; i--){
            map[sx][i] = map[sx][i-1];
        }
        
        // 아래
        before = next;
        next = map[ex][ey];
        for(int i = ex; i > sx+1; i--){
            map[i][ey] = map[i-1][ey];
        }
        map[sx+1][ey] = before;
        
        // 오른쪽
        before = next;
        next = map[ex][sy];
        for(int i = sy; i < ey-1; i++){
            map[ex][i] = map[ex][i+1];
        }
        map[ex][ey-1] = before;
        
        // 위
        for(int i = sx; i < ex-1; i++){
            map[i][sy] = map[i+1][sy];
        }
        map[ex-1][sy] = next;
        
        for(int i = sx; i < ex+1; i++){
            min = Math.min(min, map[i][sy]);
            min = Math.min(min, map[i][ey]);
        }
        
        for(int i = sy; i < ey+1; i++){
            min = Math.min(min, map[sx][i]);
            min = Math.min(min, map[ex][i]);
        }
        
        return min;
    }
    
    
}