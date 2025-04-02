import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static boolean binarySearch(int[] listA, int target) {
        int left = 0;
        int right = listA.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (listA[mid] == target) {
                return true;
            } else if (listA[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] listA = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            listA[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(listA);

        int M = Integer.parseInt(br.readLine());
        int[] listB = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            listB[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int target : listB) {
            sb.append(binarySearch(listA, target) ? "1 " : "0 ");
        }
        System.out.println(sb.toString().trim());
    }
}

