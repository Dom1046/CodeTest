package code.test;

import java.util.*;

//옹알이2
public class CodeTest41 {
    public int solution(String[] babbling) {
        int answer = 0;
        for (String bab : babbling) {
            bab = bab.replaceAll("ayaaya|yeye", "1");
            bab = bab.replaceAll("aya|ye|woo|ma", " ");
            if (bab.trim().isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}
