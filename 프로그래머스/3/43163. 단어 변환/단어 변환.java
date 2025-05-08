import java.util.*;

public class Solution {
    public int solution(String begin, String target, String[] words) {
        if (!Arrays.asList(words).contains(target)) return 0;

        Queue<Word> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        queue.add(new Word(begin, 0));

        while (!queue.isEmpty()) {
            Word current = queue.poll();

            if (current.word.equals(target)) {
                return current.step;
            }

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && isConvertible(current.word, words[i])) {
                    visited[i] = true;
                    queue.add(new Word(words[i], current.step + 1));
                }
            }
        }
        return 0;
    }

    private boolean isConvertible(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
        }
        return diff == 1;
    }

    private static class Word {
        String word;
        int step;

        Word(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }
}
