
public class PROGRAMMERS84512 {

	static char str[] = {'A', 'E', 'I', 'O', 'U'};
	static int answer = 0;
    static int count = 0;
	public int solution(String word) {
        dfs("", word);
        return answer;
    }
	
	static void dfs(String cur, String word) {
        if(cur.equals(word)) {
            answer = count;
			return;
		}
        
		if(cur.length() >= 5) {
			return;
		}
		
		for(int i = 0; i < 5; i++) {
			count++;
			dfs(cur+str[i], word);
		}
	}

}
