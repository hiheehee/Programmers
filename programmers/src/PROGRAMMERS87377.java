import java.util.ArrayList;
import java.util.HashSet;

class PROGRAMMERS87377 {
    public String[] solution(int[][] line) {
        String[] answer;
        ArrayList<point> al = new ArrayList<>();
        HashSet<String> hs = new HashSet<>();
        
        for(int i = 0; i < line.length-1; i++){
            for(int j = i+1; j < line.length; j++){
                int a = line[i][0];
                int b = line[i][1];
                int e = line[i][2];
                
                int c = line[j][0];
                int d = line[j][1];
                int f = line[j][2];
                
                if (a*d - b*c == 0) continue;
                if(((double)b*f-e*d)%(a*d-b*c) != 0) continue;
                if(((double)e*c-a*f)%(a*d-b*c) != 0) continue;
                int x = (b*f-e*d)/(a*d-b*c);
                int y = (e*c-a*f)/(a*d-b*c);
                
                al.add(new point(x,y));
            }
        }
        
        int xMax = Integer.MIN_VALUE;
        int xMin = Integer.MAX_VALUE;
        int yMax = Integer.MIN_VALUE;
        int yMin = Integer.MAX_VALUE;
        
        for(point p : al) {
            int x = p.x;
            int y = p.y;

            xMax = Math.max(xMax, x);
            xMin = Math.min(xMin, x);
            
            yMax = Math.max(yMax, y);
            yMin = Math.min(yMin, y);
            
            hs.add(Integer.toString(x)+" "+Integer.toString(y));
        }
        
        int ind = 0;
        answer = new String[yMax-yMin+1];
        for(int j = yMax; yMin <= j; j--){
            String s = "";
            for(int i = xMin; i < xMax+1; i++){
                if(hs.contains(Integer.toString(i)+" "+Integer.toString(j))) s += "*";
                else s += ".";
            }
            answer[ind] = s;
            ind++;
        }

        return answer;
    }
    
    static class point {
        int x, y;
        
        point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}