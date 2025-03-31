import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 입력을 받음.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        
        for (int t = 0; t < T; t++) {
            long n = Long.parseLong(br.readLine().trim());
            
            // k번째 그룹: 총 항의 개수는 3 * (1 + 2 + ... + k) = (3 * k * (k+1)) / 2
            // n번째 항이 포함되는 최소의 k를 구합니다.
            // 3k^2 + 3k - 2n >= 0 인 k의 최소 정수해는
            // k = ceil((sqrt(9 + 24*n) - 3) / 6)
            double d = Math.sqrt(9 + 24 * (double)n);
            long k = (long) Math.ceil((d - 3) / 6);
            
            // k-1 그룹까지의 총 항의 개수
            long prevSum = 3 * (k - 1) * k / 2;
            long offset = n - prevSum;  // 현재 그룹 내의 위치 (1부터 3*k까지)
            
            // 결과 문자열을 구성합니다.
            if (offset <= k) { // "k dolphin(s)" 구간
                if (k == 1) {
                    sb.append("1 dolphin");
                } else {
                    sb.append(k).append(" dolphins");
                }
            } else if (offset <= 2 * k) { // "k jump(s)" 구간
                if (k == 1) {
                    sb.append("1 jump");
                } else {
                    sb.append(k).append(" jumps");
                }
            } else { // "splash" 구간
                sb.append("splash");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
