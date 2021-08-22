package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class PROGRAMMERS60061 {
    static boolean wall[][];
    static boolean bo[][];
    static int len;
    static ArrayList<coordinate> al = new ArrayList<>();
    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer;
        len = n;
        wall = new boolean[len+1][len+1];
        bo = new boolean[len+1][len+1];

        for(int i = 0; i < build_frame.length; i++){
            if(build_frame[i][3] == 0){ // 삭제
                delete(build_frame[i][0], build_frame[i][1], build_frame[i][2]);
            }else { // 생성
                if(create(build_frame[i][0], build_frame[i][1], build_frame[i][2])){
                    if(build_frame[i][2] == 1) bo[build_frame[i][0]][build_frame[i][1]] = true;
                    else wall[build_frame[i][0]][build_frame[i][1]] = true;
                } 
            }
        }

        result();
        Collections.sort(al);
        answer = new int[al.size()][3];
        for(int i = 0; i < al.size(); i++){
            answer[i][0] = al.get(i).x;
            answer[i][1] = al.get(i).y;
            answer[i][2] = al.get(i).a;
        }

        return answer;
    }

    static boolean isRange(int x, int y){
        return -1 < x && x < len+1 && -1 < y && y < len+1;
    }

    static void result(){
        for(int i = 0; i < len+1; i++){
            for(int j = 0; j < len+1; j++){
                if(wall[i][j]){
                    al.add(new coordinate(i, j, 0));
                }
                if(bo[i][j]){
                   al.add(new coordinate(i, j, 1)); 
                }
            }
        }
    }

    static boolean create(int x, int y, int isWallOrBo) {
        if(isWallOrBo == 0){ // 기둥일때
            if(y == 0) { // 바닥 위에 있거나
                return true;
            }else if((isRange(x-1, y) && bo[x-1][y]) || (isRange(x, y) && bo[x][y])){ // 보의 한쪽 끝 부분 위에 있거나
                return true;
            }else if(isRange(x, y-1) && wall[x][y-1]){ // 다른 기둥 위에 있거나
                return true;
            }
            return false;
        }else { // 보일때
            if((isRange(x, y-1) && wall[x][y-1]) || (isRange(x+1, y-1) &&  wall[x+1][y-1])){ // 한쪽 끝 부분이 기둥 위에 있거나
                return true;
            }else if(isRange(x-1, y) && bo[x-1][y] && isRange(x+1, y) && bo[x+1][y]){ // 양쪽 끝 부분이 다른 보와 동시에 연결되있거나
                return true;
            }
            return false; 
        }
    }
    
    static void delete(int x, int y, int isWallOrBo){
        if(isWallOrBo == 0) wall[x][y] = false;
        else bo[x][y] = false;
        
        boolean check = true;
        for(int i = 0; i < len+1; i++){
            for(int j = 0; j < len+1; j++){
                if(wall[i][j]){
                    if(!create(i, j, 0)) check = false;
                }
                if(bo[i][j]){
                   if(!create(i, j, 1)) check = false;
                }
            }
            if(!check){
                if(isWallOrBo == 0) wall[x][y] = true;
                else bo[x][y] = true;
                return;
            }
        }
    }

    static class coordinate implements Comparable<coordinate> {
        int x;
        int y;
        int a;

        public coordinate(int x, int y, int a){
            this.x = x;
            this.y = y;
            this.a = a;
        }

        @Override
        public int compareTo(coordinate o){
            if(this.x == o.x){
                if(this.y == o.y){
                    return this.a - o.a;
                }else{
                    return this.y - o.y;
                }
            }else{
                return this.x - o.x;
            }
        }
    }
}