package code.test;

import java.util.LinkedList;

//약수의 개수와 덧셈
public class CodeTest12 {
    public int solution(int left, int right) {
        int sum = 0;
        // 숫자 대입하기
        for (int num = left; num <= right; num++) {
            int cntDivisor = findDivisor(num);
            sum += (cntDivisor % 2 == 0) ? num : -num;
        }
        return sum;
    }

    //약수 개수 구하기
    public int findDivisor(int num) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                count++;
                if (i != Math.sqrt(num)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CodeTest12 test = new CodeTest12();
        System.out.println(test.solution(13, 17));
    }
}
