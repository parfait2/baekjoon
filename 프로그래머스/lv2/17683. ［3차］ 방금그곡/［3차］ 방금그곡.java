import java.util.Objects;

class Solution {
    public static String solution(String m, String[] musicinfos) {
        String answer = "(None)";

        int play = 0;

        // # 치환
        m = changeMelody(m);

        // 파싱하기
        // musicinfos를 시작 시간, 끝나는 시간 / 노래 제목 / 멜로디
        int len = musicinfos.length;

        int[] time = new int[len];
        String[] title = new String[len];
        String[] melody = new String[len];

        for (int i = 0; i < len; i++) {
            String[] tmp = musicinfos[i].split(",");
            int start = (Integer.parseInt(tmp[0].substring(0,2)) * 60) +
                    Integer.parseInt(tmp[0].substring(3,5));
            int end = (Integer.parseInt(tmp[1].substring(0,2)) * 60) +
                    Integer.parseInt(tmp[1].substring(3,5));
            time[i] = end - start;


            title[i] = tmp[2];
            melody[i] = changeMelody(tmp[3]);
        }


        // 각 곡마다 재생 시간만큼 돌면서 확인
        for (int i = 0; i < musicinfos.length; i++) {

            StringBuilder radio = new StringBuilder();

            // melody를 재생 시간만큼 돌린다.
            for (int j = 0; j < time[i]; j++) {
                radio.append(melody[i].charAt(j % melody[i].length()));

            }

            if(radio.toString().contains(m) && play < time[i]) {
                answer = title[i];
                play = time[i];
            }

        }

        return answer;
    }

    // 치환
    static String changeMelody(String oldMelody) {
        oldMelody = oldMelody.replaceAll("C#", "H");
        oldMelody = oldMelody.replaceAll("D#", "I");
        oldMelody = oldMelody.replaceAll("E#", "J");
        oldMelody = oldMelody.replaceAll("F#", "K");
        oldMelody = oldMelody.replaceAll("G#", "L");
        oldMelody = oldMelody.replaceAll("B#", "O");

        String newMelody = oldMelody.replaceAll("A#", "M");

        return newMelody;
    }
}