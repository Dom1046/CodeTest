package code.test;

import java.util.LinkedList;
import java.util.Queue;
//리코챗 로봇
public class CodeTest1 {
    public static final int[][] DIRECTIONS = {
            {-1, 0}, // 상
            {1, 0},  // 하
            {0, -1}, // 좌
            {0, 1}   // 우
    };

    public int solution(String[] board) {
        //보드 -> 배열 위한 2차 배열 통
        char[][] arrayBoard = new char[board.length][board[0].length()];
        // 로봇위치
        // 목표위치
        int startX = 0, startY = 0;
        int goalX = 0, goalY = 0;

        //보드를 배열로 변환
        for (int i = 0; i < board.length; i++) {
            arrayBoard[i] = board[i].toCharArray();
            for (int j = 0; j < board[0].length(); j++) {
                arrayBoard[i][j] = board[i].charAt(j);
                if (arrayBoard[i][j] == 'R') {
                    startX = i;
                    startY = j;
                }
                if (arrayBoard[i][j] == 'G') {
                    goalX = i;
                    goalY = j;
                }
            }
        }
        //BFS 사용 로직
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, 0});
        boolean[][] visited = new boolean[board.length][board[0].length()];
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currX = current[0];
            int currY = current[1];
            int moveCount = current[2];

            // BFS 들어가기전 목표지점인지 확인! 맞으면 횟수가지고 나가기 -> 발동 안할 시 moveCount 값 가지고 나갈 수 없음
            if (currX == goalX && currY == goalY) {
                return moveCount;
            }

            // 방향으로 1칸씩 움직임
            for (int[] dir : DIRECTIONS) {
                int nextX = currX;
                int nextY = currY;

                // 충돌 있을 때 까지 움직임
                while (true) {
                    int tempX = nextX + dir[0];
                    int tempY = nextY + dir[1];

                    // 충돌을 만나면 while 문 나가기
                    if (tempX < 0 || tempY < 0 || board.length <= tempX || board[0].length() <= tempY || arrayBoard[tempX][tempY] == 'D') {
                        break;
                    }

                    //충돌 없으면 다음 위치로 이동
                    nextX = tempX;
                    nextY = tempY;
                }
                if (!visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY, moveCount + 1});
                }
            }
        }
        // 목표 위치에 다다를 수 없다면 -1 return
        return -1;
    }
}
