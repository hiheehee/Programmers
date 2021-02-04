import java.util.Arrays;

public class PROGRAMMERS49191 {

	public static void main(String[] args) {
		int n = 5;
		int[][] results= {{4,3}, {4,2}, {3,2}, {1,2}, {2,5}};
		
		int answer = 0;
		int map[][] = new int[n+1][n+1];
		for(int i = 0; i < n+1; i++) {
			Arrays.fill(map[i], Integer.MAX_VALUE);
		}
		for(int i = 0; i < results.length; i++) {
			map[results[i][0]][results[i][1]] = 1;
		}

		for(int k = 1; k < n+1; k++) {
			for(int i = 1; i < n+1; i++) {
				for(int j = 1; j < n+1; j++) {
					if(i == j) map[i][j] = 0;
					if(map[i][k] == Integer.MAX_VALUE || map[k][j] == Integer.MAX_VALUE) continue; 
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
		
		for(int i = 1; i < n+1; i++) {
			boolean check = true;
			for(int j = 1; j < n+1; j++) {
				if(map[i][j] == Integer.MAX_VALUE && map[j][i] == Integer.MAX_VALUE) {
					check = false;
					break;
				}
			}
			if(check) {
				answer++;
			}
		}
		
		System.out.println(answer);
	}

}
