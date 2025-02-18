package code.test;

import java.math.BigInteger;

//멀리뛰기
public class CodeTest53 {
    //fibo가 엄청 커지기 전에 1234567로 나누기
//    public long solution(int n) {
//        long answer = 0;
//
//        long[] fibo = new long[n + 2];
//
//        fibo[1] = 1;
//        fibo[2] = 2;
//
//        for (int i = 3; i <= n+1; i++) {
//            fibo[i] = (fibo[i - 1] + fibo[i - 2]);
//        }
//
//        answer = fibo[n];
//        return answer;
//    }
    //BigInteger로 풀기
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

    public static void main(String[] args) {
        CodeTest53 codeTest53 = new CodeTest53();
        long answer = codeTest53.solution(2000);
        System.out.println("answer = " + answer);
    }
}
