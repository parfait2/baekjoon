import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> solution(String msg) {
        
        ArrayList<Integer> answer = new ArrayList<>();

        // 사전
        ArrayList<String> alphabet = new ArrayList<>();

        // 사전 초기화
        for(int i = 0; i < 26; i++) {
            alphabet.add(Character.toString((char) (i + 65)));
        }

        int remain = 0;

        for(int i = 0; i < msg.length(); i++) {
            String w = "";
            String str = "";

            // 현재 인덱스에 해당하는 문자를 한 글자를 str 담는다.
            str += msg.charAt(i);

            for(int j = i + 1; j < msg.length(); j++) {
                // str을 w에 저장한다.
                w = str;

                // str에 그 다음 한 글자를 더 붙인다.
                str += msg.charAt(j);

                if(!alphabet.contains(str)) { // str이 새로운 단어이며,

                    alphabet.add(str); // 사전에 str을 등록한다.

                    /* 중요 */
                    if(w.length() > 1) i += w.length() - 1; // w이 두 글자 이상이면 i 인덱스가 (글자 길이 - 1)에 가게 한다.

                    remain = i; // i 인덱스를 remain에 잠시 저장한다. (마지막으로 처리되지 않은 글자)

                    answer.add(alphabet.indexOf(w) + 1); // 사전에서 w의 색인 번호를 찾아 정답 배열에 담는다.

                    break;
                }
            }
        }

        String lastStr = "";

        // 입력이 길이가 1인 문자열일 때
        if(msg.length() == 1) {
            answer.add(1);
        } else {
            // 길이가 2 이상의 문자열은 위의 로직을 거치고 옴
            // 마지막 남은 글자 answer에 추가
            for(int i = remain + 1; i < msg.length(); i++) {
                lastStr += msg.charAt(i);
            }

            // 새로운 단어는 위의 로직에서 모두 등록을 마쳤기 때문에
            // lastStr은 무조건 사전에 등록된 단어이다.
            answer.add(alphabet.indexOf(lastStr) + 1);
        }

        return answer;
    }
}