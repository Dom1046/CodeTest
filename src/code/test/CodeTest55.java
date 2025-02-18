package code.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//계단오르기
public class CodeTest55 {
    public void answer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int listSize = Integer.parseInt(br.readLine());

        int[] stairs = new int[listSize];
        for (int i = 0; i < listSize; i++) {
            stairs[i] = Integer.parseInt(br.readLine());

        }

        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        int n = listSize-1;

        while (n > 2) {
            int conditionA = stairs[n - 3] + stairs[n - 1] + stairs[n];
            n -= 3;
            sum1 += conditionA;
        }
        sum1 += Math.max(stairs[0], stairs[1]);
        n = listSize-1;
        while (n > 2) {
            int conditionB = stairs[n - 3] + stairs[n - 2] + stairs[n];
            n -= 3;
            sum2 += conditionB;
        }
        sum2 += stairs[0];

        n = listSize-1;
        while (n > 3) {
            int conditionC = stairs[n - 4] + stairs[n - 2] + stairs[n];
            n -= 4;
            sum3 += conditionC;
        }
        sum3 += stairs[0];

        System.out.println("sum1 = " + sum1+", "+ "sum2 = " + sum2+", "+ "sum3 = " + sum3);
        int answer = Math.max(Math.max(sum1, sum2),sum3);
        System.out.println("answer = " + answer);
    }

    public static void main(String[] args) throws IOException {
        CodeTest55 codeTest55 = new CodeTest55();
        codeTest55.answer();
    }
}
