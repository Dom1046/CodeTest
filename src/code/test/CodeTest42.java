package code.test;
//점프와 순간이동
public class CodeTest42 {
    public int solution(int n) {
        int ans = 0;
        while (n > 0) {
            if (n % 2 == 0) n/=2;
            else {
                n-=1;
                ans++;
                if (n == 0) break;
                n/=2;
            }
        }
        return ans;
    }
}
