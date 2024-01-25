import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public ArrayList<Integer> solution(String msg) {
        // 문자열을 압축한 후의 사전 색인 번호
        ArrayList<Integer> answer = new ArrayList<>();

        // 사전
        HashMap<String, Integer> alphabet = new HashMap<>();

        // 사전 초기화
        for(int i = 0; i < 26; i++) {
            alphabet.put(Character.toString((char) (i + 65)), i + 1);
        }

        int remain = 0;

        for(int i = 0; i < msg.length(); i++) {
            StringBuilder w = new StringBuilder();
            StringBuilder str = new StringBuilder();

            // 현재 인덱스에 해당하는 문자를 한 글자를 str 담는다.
            str.append(msg.charAt(i));

            for(int j = i + 1; j < msg.length(); j++) {
                // str을 w에 저장한다.
                w.setLength(0);
                w.append(str);

                // str에 그 다음 한 글자를 더 붙인다.
                str.append(msg.charAt(j));

                if (!alphabet.containsKey(str.toString())) { // str이 새로운 단어라면
                    alphabet.put(str.toString(), alphabet.size() + 1); // 사전에 str을 등록한다.

                    if(w.length() > 1) i += w.length() - 1; // w이 두 글자 이상이면 i 인덱스가 (글자 길이 - 1)에 가게 한다.

                    remain = i; // i 인덱스를 remain에 잠시 저장한다. (마지막으로 처리되지 않은 글자)

                    answer.add(alphabet.get(w.toString())); // 사전에서 w의 색인 번호를 찾아 정답 배열에 담는다.

                    break;
                }
            }
        }

        // 입력이 길이가 1인 문자열일 때
        if(msg.length() == 1) {
            answer.add(1);
        }

        // 마지막 글자 처리
        if (remain < msg.length() - 1) {
            String lastStr = msg.substring(remain + 1);
            answer.add(alphabet.get(lastStr));
        }

        return answer;
    }
}