import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class PROGRAMMERS1836 {
	static ArrayList<coordinate> al[] = new ArrayList[26];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static char map[][];
	public static void main(String[] args) {
		int m = 5;
		int n = 5; 
		String[] board = {"FGHEI", "BAB..", "D.C*.", "CA..I", "DFHGE"};
		
		
		
		HashSet<Character> hs = new HashSet<>();
        String answer = "";
		map = new char[m][n];
		int count = 0;
		
		for(int i = 0; i < 26; i++) {
			al[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			String str[] = board[i].split("");
			for(int j = 0; j < n; j++) {
				map[i][j] = str[j].charAt(0);
				if('A' <= str[j].charAt(0) && str[j].charAt(0) <= 'Z') {
					al[str[j].charAt(0)-'A'].add(new coordinate(i, j, 0, 0));
					count++;
                    hs.add(str[j].charAt(0));
				}
			}
		}
		
		count /= 2;
		while(count-- >= 0) {
			for(int i = 0; i < 26; i++) {
				if(al[i].size() > 0) {
					if(bfs(m, n, i)) {
						answer += (char)(i+65);
						break;
					}
				}
			}
		}

		if(hs.size() != answer.length()) answer = "IMPOSSIBLE";
		System.out.println(answer);
		
	}
	
	static boolean bfs(int m, int n, int ind) {
		Queue<coordinate> q = new LinkedList<>();
		q.add(new coordinate(al[ind].get(0).x, al[ind].get(0).y, 0, 0));
		q.add(new coordinate(al[ind].get(0).x, al[ind].get(0).y, 1, 0));
		q.add(new coordinate(al[ind].get(0).x, al[ind].get(0).y, 2, 0));
		q.add(new coordinate(al[ind].get(0).x, al[ind].get(0).y, 3, 0));
		
		while(!q.isEmpty()) {
			coordinate cur = q.poll();
			if(cur.count > 1) continue;
			
			if(cur.x == al[ind].get(1).x && cur.y == al[ind].get(1).y) {
				map[al[ind].get(0).x][al[ind].get(0).y] = map[al[ind].get(1).x][al[ind].get(1).y] = '.';
				al[ind].remove(1);
				al[ind].remove(0);
				return true;
			}

			
			for(int i = 0; i < 4; i++) {
				int tx = dx[i] + cur.x;
				int ty = dy[i] + cur.y;
				
				if(tx < 0 || m <= tx || ty < 0 || n <= ty) continue;
				if(map[tx][ty] == '*') continue; 
				if(map[tx][ty] == '.' || map[tx][ty] == map[al[ind].get(0).x][al[ind].get(0).y]) {
					if(cur.dir == i) q.add(new coordinate(tx, ty, i, cur.count));
					else q.add(new coordinate(tx, ty, i, cur.count+1));
				}
				
				
			}
		}
		
		return false;
	}
	
	static class coordinate {
		int x;
		int y;
		int dir;
		int count;
		
		coordinate(int x, int y, int dir, int count){
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.count = count;
		}
	}

}
