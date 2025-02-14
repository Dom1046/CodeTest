class Solution {
    public long solution(int n) {
        long answer = 0;

        long[] fibo = new long[n + 2];

        fibo[1] = 1;
        fibo[2] = 2;

        for (int i = 3; i <= n+1; i++) {
            fibo[i] = (fibo[i - 1] + fibo[i - 2])%1234567;
        }

        answer = fibo[n];
        return answer;
    }
}