import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, S, B;
	static int [] arrSour;
	static int [] arrBitter;
	static int res;

	static int cnt = 0;
	static boolean [] isSelected;
	static StringBuilder stringBuilder = new StringBuilder();

	static void subset(int [] arr1, int [] arr2, int num) {
		int S = 1;
		int B = 0;
		
		// 종료 조건
		if(num == N) {
			cnt++;

			for(int i = 0; i < N; i++) {
				if(isSelected[i]) {
					S *= arr1[i];
					B += arr2[i];
				}				
			}

			if(Math.abs(S-B) < res && B > 0) res = Math.abs(S-B);
			return;
		}
		
		isSelected[num] = true;
		subset(arr1, arr2, num+1);

		isSelected[num] = false;
		subset(arr1, arr2, num+1);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(bf.readLine());
		
		arrSour = new int[N];
		arrBitter = new int[N];
		res = 1_000_000_000;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			arrSour[i] = Integer.parseInt(st.nextToken());
			arrBitter[i] = Integer.parseInt(st.nextToken());
		}
		
		isSelected = new boolean[N];
		
		subset(arrSour,arrBitter, 0);
		System.out.print(Math.abs(res));
	}
}