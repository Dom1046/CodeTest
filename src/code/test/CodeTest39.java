package code.test;

import java.util.*;

public class CodeTest39 {
    public int solution(int n, int m, int[] section) {
        Set<Integer> notYet = new HashSet<>();
        int i = 0;
        int paintCnt = 0;

        // 칠해야 할 벽 정보 저장
        for (int sec : section) {
            notYet.add(sec);
        }
        //벽에 페인트 칠하기
        while (!notYet.isEmpty()) {
            int start = section[i];
            int end = section[i] + m - 1;

            // 해당 범위를 칠하고 제거
            for (int j = start; j <= end; j++) {
                notYet.remove(j);
            }
            //횟수 증가
            paintCnt++;

            while (i < section.length && section[i] <= end) {
                i++;
            }
        }
        return paintCnt;
    }
}
