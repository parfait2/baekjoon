import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	
    public int solution(int n, int[][] edge) {
    	// graph와 visited는 배열의 크기가 n + 1이다.
        for(int i = 0; i <= n; i++) graph.add(new ArrayList<>()); // []이 들어가 있음.
        for(int[] i : edge) {
        	graph.get(i[0]).add(i[1]); // 맨 처음 실행 시 get은 [] 반환. 빈 배열에 add 하게 됨.
        	graph.get(i[1]).add(i[0]);
        }
        boolean[] visit = new boolean[n + 1];
        
        return bfs(graph, n, visit);
    }
    
    public static int bfs(ArrayList<ArrayList<Integer>> graph, int n, boolean[] visit) {
    	Queue<int[]> queue = new LinkedList<>();
    	int answer = 0;
    	
    	queue.add(new int[] {1, 0});
    	visit[1] = true;
    	int maxDepth = 0;
    	
    	while(!queue.isEmpty()) {
    		int[] arr = queue.poll();
    		int v = arr[0];
    		int depth = arr[1];
    		
    		if(maxDepth == depth) answer++;
    		else if(maxDepth < depth) {
    			maxDepth = depth;
    			answer = 1;
    		}
    		
    		for(int i = 0; i < graph.get(v).size(); i++) {
    			int w = graph.get(v).get(i); // 인접 정점
    			
    			if(!visit[w]) {
    				queue.add(new int[] {w, depth + 1});
    				visit[w] = true;
    				}
    			}
    		}
    	return answer;
    }
}
