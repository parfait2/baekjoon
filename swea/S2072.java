package S2072;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("src/S2072/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());

			int n = 0;
			int sum = 0;

			for (int i = 0; i < 10; i++) {
				n = Integer.parseInt(st.nextToken());

				if (n % 2 == 0)
					continue;

				sum += n;
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#");
			sb.append(test_case);
			sb.append(" ");
			sb.append(sum);
			
			System.out.println(sb);
		}
	}
}
