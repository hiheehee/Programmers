public class PROGRAMMERS77885 {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int n = 100000;
		
        for(int i = 0; i < answer.length; i++){
            if(numbers[i]%2 == 0){
                answer[i] = numbers[i]+1;
            }else{
            	boolean check = false;
                String str = Long.toBinaryString(numbers[i]);
                for(int j = str.length()-1; -1 < j; j--) {
                	if(str.substring(j, j+1).equals("0")) {
                		check = true;
                		String tmp = str.substring(0, j)+"10"+str.substring(j+2);
                		str = tmp;
                		break;
                	}
                }
                if(!check) {
                	str = "10" + str.substring(1);
                }
                answer[i] = Long.parseLong(str,2);
            }
            
        }
        return answer;
    }
}