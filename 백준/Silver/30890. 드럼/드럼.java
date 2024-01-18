import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int left = Integer.parseInt(st.nextToken());
        int right = Integer.parseInt(st.nextToken());

        int lcm = left * right / gcd(left, right); // 최소공배수(least common multiple)

        StringBuilder sb = new StringBuilder();

        int answer = 0;

        for (int i = 1; i <= lcm; i++) {

            answer = 0;

            if ((left * i) % lcm == 0) {
                answer += 1;
            }
            if ((right * i) % lcm == 0) {
                answer += 2;
            }
            if(answer != 0) sb.append(answer);
        }

        System.out.println(sb);
    }

    public static int gcd(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return gcd(num2, num1 % num2);
    }
}
