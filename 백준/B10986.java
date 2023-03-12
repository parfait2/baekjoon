import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(reader.readLine(), " ");
		int N = Integer.parseInt(str.nextToken()); 
		int M = Integer.parseInt(str.nextToken());
		
		long sum = 0;
		long [] rem = new long [M];
				
		long count = 0;
		
		str = new StringTokenizer(reader.readLine() , " ");
		
		for (int i = 0; i < N; i++) {	
			sum = (Integer.parseInt(str.nextToken()) + sum) % M;
			rem[(int) sum]++;
		}
		count += rem[0];

		for (int i = 0; i < M; i++) {
			count += (rem[i] * (rem[i] - 1)/2);
		}
		System.out.println(count);
	}
}
