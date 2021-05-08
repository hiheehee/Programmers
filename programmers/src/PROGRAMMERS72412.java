import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PROGRAMMERS72412 {
	static int answer[];
	static int index = 0;
    static HashMap<Integer, String> hm = new HashMap<>();
	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		answer = new int[query.length];
        hm.put(0, "cpp java python");
        hm.put(1, "backend frontend");
        hm.put(2, "junior senior");
        hm.put(3, "chicken pizza");
        
        Node root = new Node();
        
        for(String s : info) { 
            insert(root, s); 
        }
        
        for(String s : query) { 
            check(root, s, 0);
            index++;
        } 
                
        for(int i: answer) {
        	System.out.println(i);
        }
        //return answer;
    } 
	
    static void check(Node cur, String s, int ind) {
        String str[] = s.split(" and ");
        String temp[] = str[3].split(" ");
        str[3] = temp[0];
        int score = Integer.parseInt(temp[1]);

        if(ind == 4){
            ArrayList<Integer> result = cur.score;
            Collections.sort(result);

            int start = 0;
            int end = result.size();

            
            while (start < end) {
                int mid = (start + end) / 2;
                if(result.get(mid) < score) {
                    start = mid + 1;
                }else {
                    end = mid;
                }
            }

            answer[index] += result.size() - start;
            
            return;
        }else {
        	if(str[ind].equals("-")) {
                String t[] = hm.get(ind).split(" ");
                for(String next : t) {
                	if(cur.children.containsKey(next)) check(cur.children.get(next), s, ind+1);
                }
            }else {
            	if(cur.children.containsKey(str[ind])) check(cur.children.get(str[ind]), s, ind+1);
            }
        }
    }
    
    static void insert(Node cur, String s) {
        String str[] = s.split(" ");
        
        for(int i = 0; i < str.length; i++) {
            if(i == 4){
                cur.score.add(Integer.parseInt(str[4]));
            }else {
                cur = cur.children.computeIfAbsent(str[i], l -> new Node());
            }
        }
    }
    
    static class Node{ 
        Map<String, Node> children; 
        ArrayList<Integer> score;
        
        Node() { 
            children = new HashMap<>();
            score = new ArrayList<>();
        }
    } 
}