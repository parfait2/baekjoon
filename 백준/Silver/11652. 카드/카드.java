import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());

        // 카드의 숫자와 그 빈도를 저장할 자료구조 생성
        Map<Long, Integer> m = new HashMap<>();

        /*
        * 맵 -> 카드들은 중복이 가능한 형태의 여러 숫자들이 등장
        * -> 중복되지 않은 고유한 숫자 목록 : 해당 숫자가 몇 번 등장했는지
        * -> 카운팅 / 1) 인덱스 2) 해시맵 자료형에서의 키 -> 0++
        * */

        long c = 0;

        // 각 숫자의 빈도를 저장
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            c = Long.parseLong(st.nextToken());

            // map -> 데이터를 넣는다.
            m.put(c, m.getOrDefault(c, 0) + 1);
        }

        long answer = Long.MAX_VALUE;
        int v = Collections.max(m.values());

        // 저장한 숫자와 빈도를 순회
        for (Map.Entry<Long, Integer> entry : m.entrySet()) {
            Long key = entry.getKey();
            Integer value = entry.getValue();

            if (value.equals(v)) {
                answer = Math.min(answer, key);
            }
        }

        // 가장 빈도가 높은 숫자 출력
        System.out.println(answer);

    }
}