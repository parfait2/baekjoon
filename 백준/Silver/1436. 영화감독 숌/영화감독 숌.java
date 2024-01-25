import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // 첫째 줄에 N번째 영화의 제목에 들어간 수를 출력한다.
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();

        int idx = 665;
        String str;

        while(true) {
            idx++;
            str = String.valueOf(idx);

            if(str.contains("666")) N--;

            if(N == 0) break;
        }

        System.out.print(idx);

    }
}
