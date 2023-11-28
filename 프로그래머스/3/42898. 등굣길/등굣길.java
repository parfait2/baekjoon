class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] route = new int[m + 1][n + 1];
        
        for(int i = 0; i < puddles.length; i++) {
        	route[puddles[i][0]][puddles[i][1]] = -1;
        }
        
        route[1][1] = 1;
        
        for(int i = 1; i <= m; i++) {
        	for(int j = 1; j <= n; j++) {
        		if(route[i][j] == -1) {
        			continue;
        		}
        		
        		if(route[i-1][j] == -1) route[i][j] += route[i][j-1] % 1_000_000_007;
        		else if(route[i][j-1] == -1) route[i][j] += route[i-1][j] % 1_000_000_007;
        		else route[i][j] += (route[i-1][j] + route[i][j-1]) % 1_000_000_007;
        	}
        }
        return route[m][n];
    }
}
