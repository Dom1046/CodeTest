package code.test;

public class CodeTest14 {
    public String solution(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n / 2; i++) {
            sb.append("수박");
        }
        if (n % 2 != 0) {
            sb.append("수");
        }
        return sb.toString();
    }
}
