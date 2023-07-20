class Solution {
    public int solution(String dartResult) {
        int answer = 0;

        int[] score = new int[3];
        int[] bonus = new int[3];
        char[] option = new char[3];

        int scoreCnt = 0;
        int bonusCnt = 0;

        for(int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);

            if(isNum(c)) {
                int num = c - 48;

                // 점수가 10일 때
                if(num == 1 && dartResult.charAt(i + 1) - 48 == 0) {
                    score[scoreCnt++] = 10;
                    i++;
                } else {
                    score[scoreCnt++] = num;
                }
            }

            switch (c) {
                case 'S':
                    bonus[bonusCnt++] = 1;
                    break;
                case 'D':
                    bonus[bonusCnt++] = 2;
                    break;
                case 'T':
                    bonus[bonusCnt++] = 3;
                    break;
                case '*':
                case '#':
                    option[bonusCnt - 1] = c;
                    break;
                default:
                    break;
            }
        }

        // 옵션을 점수화한 결과를 담는 배열
        int[] optRes = new int[] {1, 1, 1}; // 곱하기 연산이므로 1로 초기화한다.

        for(int i = 2; i >= 0; i--) {
            if (option[i] == '*') {
                optRes[i] *= 2;
                if (i > 0) {
                    optRes[i - 1] *= 2;
                }
            } else if (option[i] == '#') {
                optRes[i] *= -1;
            }
        }

        // 다트 게임은 세 번의 기회가 주어진다.
        for(int i = 0; i < 3; i++) {
            answer += ((int) Math.pow(score[i] , bonus[i])) * optRes[i];
        }

        return answer;
    }

    // char가 0~9인지 체크하는 함수
    public static boolean isNum(char c) {
        return 47 < c && c < 58;
    }
}