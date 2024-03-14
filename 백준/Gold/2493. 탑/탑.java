import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Top {
    int idx;
    int height;
    Top(int idx, int height) {
        this.idx = idx;
        this.height = height;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Top> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();
        String[] str = br.readLine().split(" ");

        for (int i = 1; i <= N; i++) {
            int height = Integer.parseInt(str[i - 1]);

            while (true) {
                if (stack.isEmpty()) {
                    answer.append("0 ");
                    stack.push(new Top(i, height));
                    break;
                }

                Top top = stack.peek();

                if (top.height > height) {
                    answer.append(top.idx + " ");
                    stack.push(new Top(i, height));
                    break;
                } else {
                    stack.pop();
                }
            }
        }
        System.out.println(answer);
    }
}