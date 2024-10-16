package code.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// 공원 돗자리
public class CodeTest3 {
    public int solution(int[] mats, String[][] park) {

        List<Integer> matsList = new ArrayList<>();
        for (int mat : mats){
            matsList.add(mat);
        }
        Collections.sort(matsList);
        Collections.reverse(matsList);

        int horizontal  = park.length;
        int vertical = park[0].length;

        // 각 돗자리 크기에 대해 검사
        for (int size : matsList) {
            // 공원의 모든 위치를 탐색
            for (int i = 0; i <= horizontal - size; i++) {
                for (int j = 0; j <= vertical - size; j++) {
                    if (canPlaceMat(park, i, j, size)) {
                        return size;
                    }
                }
            }
        }
        return -1;
    }

    // 돗자리를 놓을 수 있는지 확인하는 함수
    private boolean canPlaceMat(String[][] park, int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (!park[i][j].equals("-1")) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] mats = new int[]{5, 3, 2};
        String[][] park = new String[][]{{"A", "A", "-1", "B", "B", "B", "B", "-1"}, {"A", "A", "-1", "B", "B", "B", "B", "-1"}, {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"}, {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}, {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"}, {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}};
        CodeTest3 codeTest3 = new CodeTest3();
        codeTest3.solution(mats, park);
        System.out.println("result = " + codeTest3.solution(mats, park));
    }
}
