import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int [] res;
	static ArrayList <Integer> [] graph;
	static boolean [] isVisited;
	
	public static void searchBFS(int start) {
		Queue <Integer> que = new LinkedList<>();
		que.add(start);
		isVisited[start] = true;
		while(!que.isEmpty()) {
			int nowNode = que.poll();
			for(int nextNode : graph[nowNode]) {
				if(isVisited[nextNode] == true) continue;
				isVisited[nextNode] = true;
				que.add(nextNode);
				res[nextNode]++;
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList [N+1];
		
		for(int i = 0; i < N+1; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph[A].add(B);
		}
		// end of input
		
		int max = 0;
		StringBuilder sb = new StringBuilder();
		res = new int[N+1];
		
		for(int i = 1; i < N+1; i++) {
			isVisited = new boolean [N+1];
			isVisited[i] = true;
			searchBFS(i);
		}
				
		for(int i = 1; i < N+1; i++) {
			if(max < res[i]) max = res[i];
		}
		
		int tmp = 0;
		for(int i = 1; i < N+1; i++) {
			if(max == res[i]) {
				if(tmp != 0) sb.append(" ");
				tmp++;
				sb.append(i);
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
