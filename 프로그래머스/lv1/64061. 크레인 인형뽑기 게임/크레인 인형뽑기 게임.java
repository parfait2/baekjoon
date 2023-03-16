import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
		int bLen = board.length;
		int mLen = moves.length;
		
		Stack<Integer> stack = new Stack<>();
		
		int doll = 0;
		int answer = 0;
		
		for(int i = 0; i < mLen; i++) {
			for(int j = 0; j < bLen; j++) {
				doll = board[j][moves[i]-1];
				if(doll != 0) {
					if(!stack.isEmpty() && stack.peek() == doll) {
						stack.pop();
						answer += 2;
					} else stack.add(doll);
					board[j][moves[i]-1] = 0;
					break;
				} else doll = 0;
			}
		}
        return answer;
    }
}