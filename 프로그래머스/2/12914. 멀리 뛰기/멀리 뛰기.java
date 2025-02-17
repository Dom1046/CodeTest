import java.math.BigInteger;
class Solution {
    public long solution(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        BigInteger prev = BigInteger.valueOf(1); // fib(1) = 1
        BigInteger curr = BigInteger.valueOf(2); // fib(2) = 2
        BigInteger mod = BigInteger.valueOf(1234567);

        for (int i = 3; i <= n; i++) {
            BigInteger next = prev.add(curr);
            prev = curr;
            curr = next;
        }

        return curr.mod(mod).longValue(); // long 타입으로 변환하여 반환
    }
}