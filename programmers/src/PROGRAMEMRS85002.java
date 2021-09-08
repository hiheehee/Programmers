import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class PROGRAMEMRS85002 {
	static List<boxer> boxers = new ArrayList<>();
    public int[] solution(int[] weights, String[] head2head) {
        int[] answer = new int[weights.length];
        
        for(int i = 0; i < head2head.length; i++) {
        	int all = 0;
        	int winCount = 0;
            
            String str[] = head2head[i].split("");
		    int count = 0;
		    for(int j = 0; j < str.length; j++) {
                if(str[j].equals("W") || str[j].equals("L")){
                    all++;
                    if(str[j].equals("W")) winCount++;
                    if (str[j].equals("W") &&  weights[i] < weights[j]) count++;
                }
		    }

        	boxers.add(new boxer(i+1, weights[i], count, winCount, all));
        }
        
        Collections.sort(boxers);
        
        for(int i = 0; i < boxers.size(); i++) {
        	answer[i] = boxers.get(i).ind;
        }
        
        return answer;
    }

	static class boxer implements Comparable<boxer> {
		int ind;
		double winPro = 0;
		int heavy;
		int wei;
		int wincount;
		int all;
		
		boxer (int ind, int wei, int heavy, int wincount, int all) {
			this.ind = ind;
			this.wei = wei;
			this.heavy = heavy;
			this.wincount = wincount;
			this.all = all;
            if(all > 0) winPro = (double)wincount/all;
		}

		@Override
		public int compareTo(boxer o) {
			if(o.winPro != this.winPro) {
				return Double.compare(o.winPro, this.winPro);
			}else{
                if(this.heavy != o.heavy) {
                    return o.heavy - this.heavy;
				}else {
                    if(this.wei != o.wei) {
                        return o.wei - this.wei;
					}else {
                        return this.ind - o.ind;
					}
				}
            }
		}
		
	}
}
