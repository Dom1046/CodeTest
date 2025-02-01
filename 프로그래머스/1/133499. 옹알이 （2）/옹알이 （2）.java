import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for (String bab : babbling) {
            bab = bab.replaceAll("ayaaya|yeye|woowoo|mama", "1");
            bab = bab.replaceAll("aya|ye|woo|ma", " ");
            bab = bab.replaceAll(" ", "");
            if (bab.isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}