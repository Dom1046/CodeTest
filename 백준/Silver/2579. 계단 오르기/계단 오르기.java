import java.io.IOException;
import java.util.Scanner;

//계단오르기
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int numOfStairs = sc.nextInt();
        int[] stairs = new int[numOfStairs];

        for (int i = 0; i < numOfStairs; i++) {
            stairs[i] = sc.nextInt();
        }

        System.out.println(getMaxScoreBy(stairs));
    }

    public static int getMaxScoreBy(int[] stairs) {
        int n = stairs.length;
        if (n == 0) return 0;
        if (n == 1) return stairs[0];
        if (n == 2) return stairs[0] + stairs[1];

        int[] dp = new int[n];
        dp[0] = stairs[0];
        dp[1] = stairs[0] + stairs[1];
        dp[2] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]);

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(
                    dp[i-2] + stairs[i],        // 한 계단 건너뛰고 현재 계단 밟기
                    dp[i-3] + stairs[i-1] + stairs[i]  // 두 계단 건너뛰고 현재와 이전 계단 밟기
            );
        }

        return dp[n-1];
    }
}
