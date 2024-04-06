import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");

        int N = Integer.parseInt(tmp[0]);
        int X = Integer.parseInt(tmp[1]);

        String[] visitors = br.readLine().split(" ");
        // end of input

        int visitorsLen = visitors.length;
        int[] sumVisitor = new int[visitorsLen + 1]; // 누적합은 인덱스가 지난 일수로 설정한다.
        sumVisitor[0] = 0;
        sumVisitor[1] = Integer.parseInt(visitors[0]);

        // 누적합
        for(int i = 2; i < visitorsLen + 1; i++) {
            sumVisitor[i] = sumVisitor[i - 1] + Integer.parseInt(visitors[i - 1]);
        }

        int answer = 0;
        int answerTmp = 0;
        int period = 1;

        for(int i = 0; i < visitorsLen - X + 1; i++) {
            answerTmp = sumVisitor[i + X] - sumVisitor[i];

            if(answerTmp == answer) period++;

            if(answerTmp > answer) {
                period = 1;
                answer = answerTmp;
            }
        }
        StringBuilder sb = new StringBuilder();

        if(answer == 0) sb.append("SAD");
        else {
            sb.append(answer);
            sb.append("\n");
            sb.append(period);
        }

        System.out.println(sb);
    }
}
