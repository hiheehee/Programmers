public class PROGRAMMERS72413 {
	public static void main(String[] args) {
		int n = 6;
		int s = 4;
		int a = 6;
		int b = 2;
		int[][] fares = {{4,1,10},{3,5,24},{5,6,2},{3,1,41},{5,1,24},{4,6,50},{2,4,66},{2,3,22},{1,6,25}};
		
		int answer = Integer.MAX_VALUE;
		int cost[][] = new int[n+1][n+1];
		
		for(int i = 0; i < fares.length; i++) {
			cost[fares[i][0]][fares[i][1]] = fares[i][2];
			cost[fares[i][1]][fares[i][0]] = fares[i][2];
		}
		
		for(int k = 1; k < n+1; k++) {
			for(int i = 1; i < n+1; i++) {
				for(int j = 1; j < n+1; j++) {
					if(i == j) continue;
					if(cost[i][k] == 0) continue;
					if(cost[k][j] == 0) continue;
					if(cost[i][j] == 0) cost[i][j] = cost[i][k] + cost[k][j];
					else cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);
				}
			}
		}
		
		for(int i = 1; i < n+1; i++) {
			if(cost[s][i] + cost[i][a] + cost[i][b] == 0) continue;
			answer = Math.min(answer, cost[s][i] + cost[i][a] + cost[i][b]);
		}
		
		System.out.println(answer);
	}

}
