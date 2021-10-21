import java.util.*;

public class PROGRAMMERS87390 {
    public Long[] solution(int n, long left, long right) {
        Long[] answer;
        ArrayList<Long> al = new ArrayList<>();
        
        for(long i = left; i < right+1; i++){
             al.add(Math.max(i/n, i%n) + 1);
        }
        
        answer = new Long[al.size()];
        for(int i = 0; i < al.size(); i++) answer[i] = al.get(i);
        return answer;
    }
}