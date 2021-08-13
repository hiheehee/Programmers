import java.util.Stack;

public class PROGRAMMERS81303 {

	public String solution(int n, int k, String[] cmd) {
		   StringBuilder sb = new StringBuilder();
		    Stack<Node> Z = new Stack<>();
		    Node root = new Node(0);
		    Node cur = root;
		    
		    for(int i = 1; i < n; i++) {
		    	Node newNode = new Node(i);
		    	cur.next = newNode;
		    	newNode.prev = cur;
		    	cur = newNode;
		    }

		    Node tail = cur;
		    tail.next = root;
		    root.prev = tail;
		    cur = root;
		    
		    while(k-- > 0) {
		    	cur = cur.next;
		    }
		    
		    for(int i = 0; i < cmd.length; i++) {
		    	String str[] = cmd[i].split(" ");
		    	
		    	if(str[0].equals("D")) {  // 다운
		    		int c = Integer.parseInt(str[1]);
		    		while(c-- > 0) {
		    			cur = cur.next;
		    		}
		    	}else if(str[0].equals("U")) { // 업
		    		int c = Integer.parseInt(str[1]);
		    		while(c-- > 0) {
		    			cur = cur.prev;
		    		}
		    	}else if(str[0].equals("C")) { // 삭제
		    		Node del = cur;
		    		Z.add(del);
		    		cur.prev.next = cur.next;
		    		cur.next.prev = cur.prev;
		    		
		    		if(cur == root) {
		    			root = cur.next;
		    			cur = root;
		    		}else if(cur == tail) {
		    			tail = cur.prev;
		    			cur = cur.prev;
		    		}else {
		    			cur = cur.next;
		    		}
		    		
		    	}else if(str[0].equals("Z")) { // 다시 불러오기
		    		Node reNode = Z.pop();
		    		reNode.prev.next = reNode;
		    		reNode.next.prev = reNode;
		    		
		    		if(reNode.value < root.value) {
		    			root = reNode;
		    		}else if(tail.value < reNode.value) {
		    			tail = reNode;
		    		}
		    
		    	}
		    }
		    for(int i = 0; i < n; i++) {
		    	if(root.value == i) {
		    		sb.append("O");
		    		root = root.next;
		    	}else {
		    		sb.append("X");
		    	}
		    }
		    
		    return sb.toString();
	}
	
	static class Node {
		Node prev;
		Node next;
		int value;
			
		Node(int value) {
			this.prev = null;
			this.next = null;
			this.value = value;
		}
	}

}