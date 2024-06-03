import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int days = 0;
    public void dfs(String[] maps, boolean[][] visited, int startX, int startY) {
        int x = startX;
        int y = startY;

        if(x < 0 || y < 0 || x >= maps.length || y >= maps[0].length()) {
            return;
        } else {
            if(maps[x].charAt(y) != 'X' && visited[x][y] != true) {
                days += maps[x].charAt(y) - '0';
                visited[x][y] = true;

                for(int i = 0; i < 4; i++) {
                    dfs(maps, visited, x + dx[i], y + dy[i]);
                }
            }
        }
    }
    
    public int[] solution(String[] maps) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length()];

        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[0].length(); j++) {
                if(maps[i].charAt(j) != 'X' && visited[i][j] != true) {
                    days = 0;
                    dfs(maps, visited, i, j);
                    list.add(days);
                }
            }
        }

        Collections.sort(list);
        answer = new int[list.size()];

        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        if(list.isEmpty()) {
            answer = new int[1];
            answer[0] = -1;
        }

        return answer;
    }
}
