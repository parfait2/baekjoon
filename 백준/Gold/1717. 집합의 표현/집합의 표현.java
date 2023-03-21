import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int [] parent;
	
	public static String unionFind(int a, int b) {
		if(a == b) return "YES";
		else return "NO";
	}
	 // x의 부모를 찾는 연산
    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
 
    // y의 부모를 x의 부모로 치환하는 연산 (x > y 일 경우, 반대)
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            if (x < y) parent[y] = x;
            else parent[x] = y;
        }
    }
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parent = new int [n+1];
		
		for(int i = 0; i < n + 1; i++) {
			parent[i] = i;
		}
		
		StringBuilder sb = new StringBuilder();
		int tmp = 0;
		
		for(int i = 0; i < m; i++) {
			// 0 1 3
			st = new StringTokenizer(br.readLine());
			int operate = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			String res = "";
			if(operate == 0) union(a, b);
			else if(operate == 1) {
				if(tmp != 0) sb.append("\n");
				tmp++;
				sb.append(unionFind(find(a), find(b)));
			}
		}
		System.out.print(sb);
	}
}