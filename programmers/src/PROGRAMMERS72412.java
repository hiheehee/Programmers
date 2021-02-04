import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class PROGRAMMERS72412 {
	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		
		String lang[] = {"cpp", "java", "python"};
		String dep[] = {"backend", "frontend"};
		String exp[] = {"junior", "senior"};
		String food[] = {"chicken", "pizza"};
		
		
		HashMap<String, HashMap<String, HashMap<String, HashMap<String, ArrayList<Integer>>>>> hm = new HashMap<>();
		
		for(String str : lang) {
			hm.put(str, new HashMap<>());
		}
		for(String l : hm.keySet()) {
			HashMap<String, HashMap<String, HashMap<String, ArrayList<Integer>>>> lhm = hm.get(l);
			for(String d: dep) 
				lhm.put(d, new HashMap<>());
			for(String d: lhm.keySet()) {
				HashMap<String, HashMap<String, ArrayList<Integer>>> dhm = lhm.get(d);
				for(String e : exp)
					dhm.put(e, new HashMap<>());
				for(String e: dhm.keySet()) {
					HashMap<String, ArrayList<Integer>> ehm = dhm.get(e);
					for(String f: food)
						ehm.put(f, new ArrayList<>());
				}

			}

		}

		int[] answer = new int[query.length];

		for(String str : info) {
			String people[] = str.split(" ");
			hm.get(people[0]).get(people[1]).get(people[2]).get(people[3]).add(Integer.parseInt(people[4]));
		}

		for (HashMap<String, HashMap<String, HashMap<String, ArrayList<Integer>>>> d : hm.values())
            for (HashMap<String, HashMap<String, ArrayList<Integer>>> e : d.values())
                for (HashMap<String, ArrayList<Integer>> f : e.values())
                    for (ArrayList<Integer> s : f.values())
                        s.sort(null);
		
		
		for(int i = 0; i < query.length; i++) {
			String str[] = query[i].split(" and ");
			String temp[] = str[3].split(" ");
			int score = Integer.parseInt(temp[1]);
			
			for(String l : lang) {
				if(str[0].equals("-") || str[0].equals(l)) {
					for(String d: dep) {
						if(str[1].equals("-") || str[1].equals(d)) {
							for(String e: exp) {
								if(str[2].equals("-") || str[2].equals(e)) {
									for(String f : food) {
										if(temp[0].equals("-") || temp[0].equals(f)) {
											 ArrayList<Integer> result = hm.get(l).get(d).get(e).get(f);
											 for(Integer num: result) {
												 if(score <= num) {
													 answer[i]++;
												 }
											 }
										}
									}
								}
							}
						}
					}
				}
			}	
		} 
		
		
		for(int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
}