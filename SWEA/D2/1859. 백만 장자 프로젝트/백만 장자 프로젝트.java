import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        /* tc만큼 for문 */
        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine()); // i번째 테스트 케이스 자연수 N
            int[] arr = new int[N]; // 각 날의 매매가를 나타내는 N개의 자연수들을 담을 배열

            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " "); // 공백 기준으로 파싱

            // 파싱한 값 배열에 담기
            for(int j = 0; st.hasMoreTokens(); j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            long max = Long.MIN_VALUE; // 갱신할 최댓값
            int num = 0; // 사재기한 물건의 개수
            long cost = 0L; // 물건을 사는 데 들어간 비용
            long result = 0L; // 총 판매 수익

            for(int k = N - 1; k >= 0; k--) {
                if(arr[k] > max) {
                    // 최댓값 발견
                    result += (max * num - cost); // 판매 수익 업데이트
                    max = arr[k]; // 최댓값 갱신
                    cost = 0; // 비용 초기화
                    num = 0; // 사재기한 물건 개수 초기화
                } else {
                    cost += arr[k]; // 들어간 비용 업데이트
                    num++; // 사재기한 물건 개수 업데이트
                }
            }

            // for문 끝나고 난 후엔 마지막 판매 수익이 업데이트되지 않음.
            result += (max * num - cost); // 판매 수익 업데이트

            System.out.println("#" + (i + 1) + " " + result);
        }
	}
}