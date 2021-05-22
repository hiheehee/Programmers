
public class PROGRAMMERS77484 {
	public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zero = 0;
        
        // 로또 맞춘 개수 구하기
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
        
        // 맞춘 개수를 로또 순위로 바꾸기
        answer[0] = lotto(answer[0]);
        answer[1] = lotto(answer[1]);
        return answer;
    }
    
    static int lotto(int n){
        if(n == 6){ // 6개 번호가 모두 일치
            return 1; // 1등
        }else if(n == 5){ // 5개 번호가 일치
            return 2; // 2등
        }else if(n == 4){ // 4개 번호가 일치
            return 3; // 3등
        }else if(n == 3){ // 3개 번호가 일치
            return 4; // 4등
        }else if(n == 2){ // 2개 번호가 일치
            return 5; // 5등
        }else{ // 그 외
            return 6; // 6등
        }
    }
}