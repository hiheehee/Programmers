import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class PROGRAMMERS72411 {
	static HashMap<String, Integer> hm = new HashMap<>();
	public static void main(String[] args) {
		String[] orders = {"XYZ", "XWY", "WXA"};
		int[] course = {2,3,4};
		ArrayList<String> al = new ArrayList<>();
		int len[] = new int[course[course.length-1]+1];
		
		for(int i = 0; i < orders.length; i++) {
			char str[] = orders[i].toCharArray();
			Arrays.sort(str);
			for(int j = 0; j < course.length; j++) {
				if(course[j] <= orders[i].length()) {
					nCr(str, orders[i].length(), course[j], 0, "");
				}
			}
		}
		
		for(String k:hm.keySet()) {
			if(2 <= hm.get(k)) {
				if(len[k.length()] < hm.get(k)) {
					len[k.length()] = hm.get(k);
				}
			}
		}
		
		for(String k:hm.keySet()) {
			if(2 <= hm.get(k) && len[k.length()] == hm.get(k)) {
				al.add(k);
				// System.out.println(k + " "+ hm.get(k));
			}
		}
		
		Collections.sort(al);
		String[] answer = new String[al.size()];
		
		for(int i = 0; i < al.size(); i++) {
			answer[i] = al.get(i);
		}
	}
	
	static void nCr(char[] str, int n, int r, int start, String result) {
		if(r == 0) {
			hm.put(result, hm.getOrDefault(result, 0)+1);
			return;
		}else {
			for(int i = start; i < str.length; i++) {
					nCr(str, n, r-1, i+1, result+str[i]);
			}
		}
	}

}
