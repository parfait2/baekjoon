import java.util.*;
    
class Solution {
    int calculateRank(int num) {
        int rank;
        
        if(num == 6) rank = 1;
        else if(num == 5) rank = 2;
        else if(num == 4) rank = 3;
        else if(num == 3) rank = 4;
        else if(num == 2) rank = 5;
        else rank = 6;
        
        return rank;
    }
    
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        int zero_cnt = 0;
        int least = 0;
        
        for(int i = 0; i < 6; i++) {
            map.put(win_nums[i], 0);
        }
        
        for(int i = 0; i < 6; i++) {
            if(lottos[i] == 0) {
                zero_cnt++;
                continue;
            }
            
            if(map.get(lottos[i]) != null && map.get(lottos[i]) == 0) {
                least++;
            }
            
            // 0 0 1 25 31 44
            // 1 6 10 19 31 45
        }
        
//         System.out.println("zero count = " + zero_cnt);
//         System.out.println("least = " + least);
        
//         System.out.println("zero count = " + calculateRank(least));
//         System.out.println("zero count = " + calculateRank(least + zero_cnt));
        answer[0] = calculateRank(least + zero_cnt);
        answer[1] = calculateRank(least);

        // calculateRank(least);
        // caculateRank(least + zero_cnt);
        
        return answer;
    }
}