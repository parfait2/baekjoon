import java.util.ArrayList;

class Solution {
    public static ArrayList<Integer> solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();

        // 알파벳 배열 생성
        ArrayList<String> alphabet = new ArrayList<>();

        for(int i = 0; i < 26; i++) {
            alphabet.add(Character.toString((char) (i + 65)));
        }

        int remain = 0;

        for(int i = 0; i < msg.length(); i++) {
            String w = "";
            String str = "";

            str += msg.charAt(i);

            for(int j = i + 1; j < msg.length(); j++) {
                w = str;
                str += msg.charAt(j);

                if(!alphabet.contains(str)) {
                    if(alphabet.contains(w)) {
                        alphabet.add(str);

                        if(w.length() > 1) i += w.length() - 1;

                        remain = i;

                        answer.add(alphabet.indexOf(w) + 1);
                    }

                    break;
                }
            }
        }

        String lastStr = "";

        if(msg.length() == 1) {
            answer.add(1);
        } else {
            // 마지막 남은 글자 answer에 추가
            for(int i = remain + 1; i < msg.length(); i++) {
                lastStr += msg.charAt(i);
            }

            answer.add(alphabet.indexOf(lastStr) + 1);
        }

        return answer;
    }
}