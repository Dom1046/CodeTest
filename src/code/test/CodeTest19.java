package code.test;

import java.util.HashMap;

public class CodeTest19 {
    public static String solution(String[] survey, int[] choices) {
        HashMap<String, Integer> scores = new HashMap<>();
        scores.put("R", 0);
        scores.put("T", 0);
        scores.put("C", 0);
        scores.put("F", 0);
        scores.put("J", 0);
        scores.put("M", 0);
        scores.put("A", 0);
        scores.put("N", 0);

        String answer = "";
        for (int i = 0; i < survey.length; i++) {
            int choice = choices[i];
            String types = survey[i];
            if (choice == 4) continue;
            String type = (choice < 4) ? types.substring(0, 1) : types.substring(1);
            int score = scores.get(type);
            scores.put(type, score + Math.abs(choice - 4));
        }

        answer += scores.get("R") >= scores.get("T") ? "R" : "T";
        answer += scores.get("C") >= scores.get("F") ? "C" : "F";
        answer += scores.get("J") >= scores.get("M") ? "J" : "M";
        answer += scores.get("A") >= scores.get("N") ? "A" : "N";
        return answer;
    }
}
