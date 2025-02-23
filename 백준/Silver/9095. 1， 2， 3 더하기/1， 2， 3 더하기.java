import java.util.Scanner;

//1, 2, 3 더하기
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();

            int answer = 0;
            if (n > 11) {
                System.out.println("n이 11보다 큽니다.");
                break;
            }
           if (n == 1) answer = 1;
           else if (n == 2) answer = 2;
           else if (n == 3) answer = 4;
           else if (n == 4) answer = 7;
           else if (n == 5) answer = 13;
           else if (n == 6) answer = 24;
           else if (n == 7) answer = 44;
           else if (n == 8) answer = 81;
           else if (n == 9) answer = 149;
           else if (n == 10) answer = 274;
           System.out.println(answer);
        }
    }
}
