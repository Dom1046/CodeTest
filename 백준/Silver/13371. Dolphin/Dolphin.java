import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

// Dolphin
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            long n = sc.nextLong();

            // n번째 문구가 속하는 블록 k를 찾습니다.
            // 누적 문구 수는 3*(k*(k+1)/2) 이므로, 이 값이 n 이상이 되는 최소의 k를 찾습니다.
            long k = 1;
            // k에 대한 대략의 범위를 근사 계산하기 위해 이차방정식 이용
            // 3*k*(k+1)/2 >= n  -> k^2 + k - (2*n/3) >= 0
            // 근의 공식을 이용해 근사값을 구합니다.
            k = (long) Math.ceil((-1 + Math.sqrt(1 + 8.0 * n / 3)) / 2);
            // 만약 계산된 k로 누적문구 수가 n 미만이면 k++.
            while (3 * (k * (k + 1) / 2) < n) {
                k++;
            }

            // 이전 블록까지 누적 문구 수
            long prevTotal = 3 * ((k - 1) * k / 2);
            // 현재 블록 내에서의 위치 (1부터 시작)
            long pos = n - prevTotal;

            String result = "";
            if (pos <= k) {
                // dolphins 그룹
                result = k + (k == 1 ? " dolphin" : " dolphins");
            } else if (pos <= 2 * k) {
                // jumps 그룹
                result = k + (k == 1 ? " jump" : " jumps");
            } else {
                // splash 그룹
                result = "splash";
            }

            sb.append(result).append("\n");
        }
        System.out.print(sb);
        sc.close();
    }
}