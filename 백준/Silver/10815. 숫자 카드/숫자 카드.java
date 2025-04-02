import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int playCardGame(int[] listA, int b) {

        if (Arrays.binarySearch(listA, b) >= 0) {
            return 1;
        } else return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int[] arrayA = new int[num];

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            arrayA[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(arrayA);

        int M = Integer.parseInt(br.readLine());
        int[] listB = new int[M];

        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            listB[i] = Integer.parseInt(tokenizer.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int target : listB) {
            sb.append(playCardGame(arrayA, target)).append(" ");
        }

        System.out.println(sb);
        br.close();
    }
}

