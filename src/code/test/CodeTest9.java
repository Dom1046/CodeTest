package code.test;

import java.util.ArrayList;
import java.util.List;

//이웃한 칸
public class CodeTest9 {

    public int solution(String[][] board, int h, int w) {
        final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        String[][] distributedBoard = distribute(board);
        List<String> results = new ArrayList<>();
        int answer = 0;
        // 동서남북 만들기-> 리코챗에서 사용했던 방법
        for (int[] dir : DIRECTIONS) {
            int indexX = h + dir[0];
            int indexY = w + dir[1];
            // 보드 밖으로 나가면 제외
            if (indexX<0||indexY<0||indexX>= distributedBoard.length||indexY>= distributedBoard[0].length){
                continue;
            }
            results.add(distributedBoard[indexX][indexY]);
        }
        return (int)results.stream().filter(i->i.equals(board[h][w])).count();
    }

    // Board 배열로 만들기
    public String[][] distribute(String[][] board) {
        String[][] distributedBoard = new String[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                distributedBoard[i][j] = board[i][j];
            }
        }
        return distributedBoard;
    }

    public static void main(String[] args) {
        CodeTest9 test = new CodeTest9();
        String[][] board = new String[][]{{"yellow", "green", "blue"}, {"blue", "green", "yellow"}, {"yellow", "blue", "blue"}};
        int h = 0;
        int w = 1;
        System.out.println(test.solution(board, h, w));
    }
}
