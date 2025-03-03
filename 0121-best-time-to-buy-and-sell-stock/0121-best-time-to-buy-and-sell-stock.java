class Solution {
    static int max = 0;

    public int maxProfit(int[] prices) {

        int n = prices.length;
        int leastNum = prices[0];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            if (i == 0) dp[0] = 0;
            else if (prices[i] > leastNum) {
                getMax(prices[i] - leastNum);
            } else if (prices[i] < leastNum) {
                leastNum = prices[i];
            }
            dp[i] = max;
        }
        max = 0;
        return dp[n - 1];
    }

    public static void getMax(int candidate) {
        if (candidate > max) max = candidate;
    }
}