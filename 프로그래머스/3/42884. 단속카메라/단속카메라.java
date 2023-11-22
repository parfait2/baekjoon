import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] route1, int[] route2) {
                return route1[1] - route2[1];
            }
        });
        
        int exit = routes[0][1];
        int index = 1; // 현재 차량의 인덱스
        int len = routes.length;

        while(index < len) {
        	
        	if(exit >= routes[index][0] && exit <= routes[index++][1]) continue;
        	else {
        		answer++;
        		exit = routes[index++][1];
        	}
        }
        
		return answer;
    }
}
