
public class PROGRAMMERS72410 {

	public static void main(String[] args) {
		String new_id = "=.=";
		String answer = "";
		
		// 1�ܰ� new_id�� ��� �빮�ڸ� �����Ǵ� �ҹ��ڷ� ġȯ�մϴ�.
		new_id = new_id.toLowerCase();
		
		// 2�ܰ� new_id���� ���ĺ� �ҹ���, ����, ����(-), ����(_), ��ħǥ(.)�� ������ ��� ���ڸ� �����մϴ�.
		for(int i = 0; i < new_id.length(); i++) {
			if(('0' <= new_id.charAt(i) && new_id.charAt(i) <= '9') || ('a' <= new_id.charAt(i) && new_id.charAt(i) <= 'z') || new_id.charAt(i) == '-' || new_id.charAt(i) == '_' || new_id.charAt(i) == '.') {
				answer += new_id.substring(i, i+1);
			}
		}
		
		// 3�ܰ� new_id���� ��ħǥ(.)�� 2�� �̻� ���ӵ� �κ��� �ϳ��� ��ħǥ(.)�� ġȯ�մϴ�.
		while(answer.contains("..")) {
			answer = answer.replace("..", ".");
		}

		// 4�ܰ� new_id���� ��ħǥ(.)�� ó���̳� ���� ��ġ�Ѵٸ� �����մϴ�.
		if(1 <= answer.length() && answer.charAt(0) == '.') {
			answer = answer.substring(1);
		}
		
		// 4�ܰ� new_id���� ��ħǥ(.)�� ó���̳� ���� ��ġ�Ѵٸ� �����մϴ�.
		if(1 <= answer.length() && answer.charAt(answer.length()-1) == '.') {
			answer = answer.substring(0,answer.length()-1);
		}
		
		// 5�ܰ� new_id�� �� ���ڿ��̶��, new_id�� "a"�� �����մϴ�.
		if(answer.equals("")) {
			answer += "a";
		}
		
		// 6�ܰ� new_id�� ���̰� 16�� �̻��̸�, new_id�� ù 15���� ���ڸ� ������ ������ ���ڵ��� ��� �����մϴ�.
		if(16 <= answer.length()) {
			answer = answer.substring(0, 15);
		}
		// ���� ���� �� ��ħǥ(.)�� new_id�� ���� ��ġ�Ѵٸ� ���� ��ġ�� ��ħǥ(.) ���ڸ� �����մϴ�.
		if(answer.charAt(answer.length()-1) == '.') {
			answer = answer.substring(0,answer.length()-1);
		}
		
		// 7�ܰ� new_id�� ���̰� 2�� ���϶��, new_id�� ������ ���ڸ� new_id�� ���̰� 3�� �� ������ �ݺ��ؼ� ���� ���Դϴ�.
		if(answer.length() <= 2) {
			while(answer.length() != 3) {
				answer += answer.charAt(answer.length()-1);
			}
		}
		
		System.out.print(answer);
	}

}