import java.util.*;

class Main{
    public static int solveApartment(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];

        // 0층 초기화 (i호에는 i명이 산다)
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }

        // DP 채우기
        for (int floor = 1; floor <= k; floor++) {
            for (int room = 1; room <= n; room++) {
                dp[floor][room] = dp[floor][room - 1] + dp[floor - 1][room];
            }
        }

        return dp[k][n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(solveApartment(k, n));
        }
        sc.close();
    }
}