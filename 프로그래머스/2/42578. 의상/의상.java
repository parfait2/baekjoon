import java.util.HashMap;

public class Solution {
    public static int solution(String[][] clothes) {
    	int answer = 1;
    	HashMap<String, Integer> map = new HashMap<>();
    	
    	for(int i = 0; i < clothes.length; i++) {
    		map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
    	}
    	
    	for(int i = 0; i < map.keySet().size(); i++) {
        	map.get(map.keySet().toArray()[i]);        	
        	answer *= map.get(map.keySet().toArray()[i]) + 1;
    	}

    	return answer - 1;
    }
}
