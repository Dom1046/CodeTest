package code.test;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//숫자판 점프
public class CodeTest49 {

//    static Set<String> collectedNums = new HashSet<>();
//    static final int[][] Direction = {
//            {-1, 0}, // 위쪽
//            {1, 0},  // 아래쪽
//            {0, -1}, // 왼쪽
//            {0, 1}   // 오른쪽
//    };
//    static int[][] board = new int[5][5];
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        Scanner sc = new Scanner(System.in);
//        int depth = 0;
//
//        // 숫자판 입력 받기
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                board[i][j] = sc.nextInt();  // nextInt()를 사용하여 숫자 하나씩 읽기
//            }
//        }
//        sc.close();
//
//        // 모든 위치에서 탐색 시작
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                dfs(i, j, "", depth);
//            }
//        }
//
//
//        writer.flush();
//    }
//    static void dfs(int i, int j, String number, int depth){
//        if (depth == 6){
//            collectedNums.add(number);
//            return;
//        }
//
//        for (int[] dir : Direction) {
//
//            int newX = i + dir[0];
//            int newY = j + dir[1];
//
//            if (newX >= 0 && newX < 5 && newY >= 0 && newY < 5) {
//                dfs(newX, newY, number+board[newX][newY], depth++);
//            }
//        }
//    }
static int[][] board = new int[5][5];  // 5x5 숫자판
    static Set<String> uniqueNumbers = new HashSet<>(); // 중복 방지를 위한 HashSet
    static int[] dx = {-1, 1, 0, 0};  // 상하좌우 이동
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ✅ 숫자판 입력 받기
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = sc.nextInt();  // nextInt()를 사용하여 숫자 하나씩 읽기
            }
        }
        sc.close();  // 사용이 끝난 Scanner 닫기

        // ✅ 모든 위치에서 탐색 시작
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, "", 0);
            }
        }

        // ✅ 서로 다른 6자리 숫자의 개수 출력
        System.out.println(uniqueNumbers.size());
    }

    // DFS 탐색 함수
    static void dfs(int x, int y, String number, int depth) {
        if (depth == 6) {  // 여섯 자리 숫자가 만들어졌을 때
            uniqueNumbers.add(number);
            return;
        }

        for (int d = 0; d < 4; d++) {  // 네 방향 이동
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {  // 격자 범위 내 이동 가능
                dfs(nx, ny, number + board[nx][ny], depth + 1);
            }
        }
    }
}
