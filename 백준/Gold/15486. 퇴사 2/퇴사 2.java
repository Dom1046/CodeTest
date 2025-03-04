import java.util.Scanner;

//퇴사2
public class Main {
    public static void getMaxProfit(int n, int[] T, int[] P) {
        int[] dp = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i]);

            int nextDay = i + T[i] - 1;
            if (nextDay <= n) {
                dp[nextDay] = Math.max(dp[nextDay], dp[i - 1] + P[i]);
            }
        }
        System.out.println(dp[n]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] T = new int[n + 1];
        int[] P = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }
        getMaxProfit(n, T, P);
    }
}
