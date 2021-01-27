
public class PROGRAMMERS72410 {

	public static void main(String[] args) {
		String new_id = "=.=";
		String answer = "";
		new_id = new_id.toLowerCase();
		for(int i = 0; i < new_id.length(); i++) {
			if(('0' <= new_id.charAt(i) && new_id.charAt(i) <= '9') || ('a' <= new_id.charAt(i) && new_id.charAt(i) <= 'z') || new_id.charAt(i) == '-' || new_id.charAt(i) == '_' || new_id.charAt(i) == '.') {
				answer += new_id.substring(i, i+1);
			}
		}
		
		
		while(answer.contains("..")) {
			answer = answer.replace("..", ".");
		}

		if(1 <= answer.length() && answer.charAt(0) == '.') {
			answer = answer.substring(1);
		}
		
		
		if(1 <= answer.length() && answer.charAt(answer.length()-1) == '.') {
			answer = answer.substring(0,answer.length()-1);
		}
		
		if(answer.equals("")) {
			answer += "a";
		}
		
		if(16 <= answer.length()) {
			answer = answer.substring(0, 15);
		}
		
		if(answer.charAt(answer.length()-1) == '.') {
			answer = answer.substring(0,answer.length()-1);
		}
		
		if(answer.length() <= 2) {
			while(answer.length() != 3) {
				answer += answer.charAt(answer.length()-1);
			}
		}
		System.out.print(answer);
	}

}