
public class PROGRAMMERS77484 {
	public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zero = 0;
        
        // �ζ� ���� ���� ���ϱ�
        for(int i = 0; i < lottos.length; i++){
            if(lottos[i] == 0){
                zero++;
                continue;
            }
            for(int j = 0; j < win_nums.length; j++){
                if(lottos[i] == win_nums[j]){
                    answer[1]++;
                }
            }
        }
        
        answer[0] = answer[1] + zero;
        
        // ���� ������ �ζ� ������ �ٲٱ�
        answer[0] = lotto(answer[0]);
        answer[1] = lotto(answer[1]);
        return answer;
    }
    
    static int lotto(int n){
        if(n == 6){ // 6�� ��ȣ�� ��� ��ġ
            return 1; // 1��
        }else if(n == 5){ // 5�� ��ȣ�� ��ġ
            return 2; // 2��
        }else if(n == 4){ // 4�� ��ȣ�� ��ġ
            return 3; // 3��
        }else if(n == 3){ // 3�� ��ȣ�� ��ġ
            return 4; // 4��
        }else if(n == 2){ // 2�� ��ȣ�� ��ġ
            return 5; // 5��
        }else{ // �� ��
            return 6; // 6��
        }
    }
}