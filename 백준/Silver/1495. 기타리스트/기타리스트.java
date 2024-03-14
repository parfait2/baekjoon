import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int S = Integer.parseInt(str[1]);
        int M = Integer.parseInt(str[2]);

        boolean[][] dp = new boolean[N + 1][M + 1];
        dp[0][S] = true;

        str = br.readLine().split(" ");

        for (int i = 1; i <= N; i++) {
            int V = Integer.parseInt(str[i - 1]);

            for (int j = 0; j <= M; j++) {
                if (dp[i - 1][j]) {
                    if (j - V >= 0) dp[i][j - V] = true;
                    if (j + V <= M) dp[i][j + V] = true;
                }
            }
        }
        int max = -1;

        for (int i = 0; i <= M; i++) {
            if(dp[N][i]) max = Math.max(max, i);
        }
        System.out.println(max);

    }
}
