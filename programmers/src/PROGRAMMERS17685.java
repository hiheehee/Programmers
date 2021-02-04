import java.util.HashMap;
import java.util.Map;

public class PROGRAMMERS17685 {
	static int answer = 0;
	public static void main(String[] args) {
		String[] words = {"abc", "def", "ghi", "jklm"};
		
		Node root = new Node();
		for(String s : words) {
			insert(root, s);
		}
		
		for(String s : words) {
			check(root, s);
		}
		
		System.out.println(answer);
	}
	
	static void check(Node cur, String s) {
		for(char c: s.toCharArray()) {
			cur = cur.children.get(c);
			answer++;
			if(cur.count == 1) {
				return;
			}
		}
	}
	
	static void insert(Node cur, String s) {
		for(char c: s.toCharArray()) {
			cur = cur.children.computeIfAbsent(c, l -> new Node());
			cur.count++;
		}
	}
	
	static class Node{
		Map<Character, Node> children;
		int count;
		
		Node() {
			children = new HashMap<>();
		}
	}

}
