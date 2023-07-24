import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

class Solution {
    public static int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        ArrayList<String> multiset1 = new ArrayList<>();
        ArrayList<String> multiset2 = new ArrayList<>();

        multiset1 = makeMultiSet(str1);
        multiset2 = makeMultiSet(str2);

        Collections.sort(multiset1);
        Collections.sort(multiset2);

        // 같을 경우
        if(multiset1.equals(multiset2) && !multiset1.isEmpty()) {
            return 65536;
        }        

        ArrayList<String> union = new ArrayList<>();
        
        
        ArrayList<String> intersection = new ArrayList<>();
        
        for(String s : multiset1) {
            if(multiset2.remove(s)) {
                intersection.add(s);
            }
            union.add(s);
        }
        
        union.addAll(multiset2);
        
        if(union.size() == 0) return 65536;


        
        answer = (int) Math.floor((double) intersection.size() / (double) union.size() * 65536);

        return answer;
    }

    // 문자열이 영문자에 해당하는지 체크하는 함수
    public static boolean isEng(String str) {
        return str.matches("^[a-zA-Z]*$");
    }

    // 다중집합을 만드는 함수
    public static ArrayList<String> makeMultiSet(String str) {
        ArrayList<String> multiset = new ArrayList<>();

        for(int i = 0; i < str.length() - 1; i++) {
            String now = Character.toString(str.charAt(i));
            String next = Character.toString(str.charAt(i + 1));

            if(isEng(now) && isEng(next)) {
                multiset.add(now + next);
            }
        }

        return multiset;
    }
}