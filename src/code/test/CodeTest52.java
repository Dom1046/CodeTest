package code.test;

import java.io.*;
import java.util.Arrays;

//피보나치 수
public class CodeTest52 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n > 45) {
            System.out.println("NO");
        }

        int[] fibonacciNums = new int[n + 1];

        fibonacciNums[0] = 0;
        fibonacciNums[1] = 1;

        int index = 2;
        //바텀업 방식
        while (n > index - 1) {
            fibonacciNums[index] = fibonacciNums[index - 1] + fibonacciNums[index -2];
            index++;
        }
        System.out.println(fibonacciNums[n]);
        br.close();
    }


//  업다운 방식 시간초과 나옴
//    static int fibo(int n) {
//        if (fibonacciNums[n] != -1) {
//            return fibonacciNums[n];
//        }
//        return fibo(n-1) + fibo(n-2);
//    }
//    static int[] fibonacciNums;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//
//         fibonacciNums = new int[n+1];
//
//        for (int i = 0; i < n; i++) {
//            fibonacciNums[i] = -1;
//        }
//
//        fibonacciNums[0] = 0;
//        fibonacciNums[1] = 1;
//        int answer = fibo(n);
//        System.out.println(answer);
//
//        br.close();
//    }
}
