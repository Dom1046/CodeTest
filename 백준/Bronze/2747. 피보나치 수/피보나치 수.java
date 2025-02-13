import java.io.*;
import java.util.*;

class Main{
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
        while (n > index - 1) {
            fibonacciNums[index] = fibonacciNums[index - 1] + fibonacciNums[index -2];
            index++;
        }
        System.out.println(fibonacciNums[n]);
        br.close();
    }
}