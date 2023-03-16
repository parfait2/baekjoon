import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int binarySearch(int [] arr, int target) {
		int low = 0; // 시작 인덱스
		int high = arr.length-1; // 끝 인덱스
		int mid = 0;
		
		while(low <= high) {
			mid = (low + high) / 2;
			if(arr[mid] == target) return mid;
			else if(arr[mid] > target) high = mid - 1;
			else low = mid + 1;
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int arr1 [] = new int [N];
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());

		for(int i = 0; i < N; i++) {
			arr1[i] = Integer.parseInt(st1.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		int arr2 [] = new int [M];
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());

		for(int i = 0; i < M; i++) {
			arr2[i] = Integer.parseInt(st2.nextToken());
		}
		Arrays.sort(arr1);
		
		for(int i = 0; i < M; i++) {
			if(binarySearch(arr1, arr2[i]) != -1) System.out.println(1);
			else System.out.println(0);
		}
	}
}