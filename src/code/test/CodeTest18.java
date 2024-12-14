package code.test;

public class CodeTest18 {
    //머쓱이 방향키 움직이기
    public int[] solution(String[] keyinput, int[] board) {

        int upDown = 0;
        int leftRight = 0;

        for (String input : keyinput) {
            switch (input) {
                case "left":
                    if (-(board[0] / 2) <= (leftRight - 1)) {
                        leftRight -= 1;
                    }
                    break;

                case "right":
                    if (board[0] / 2 >= (leftRight + 1)) {
                        leftRight += 1;
                    }
                    break;

                case "up":
                    if (board[1] / 2 >= (upDown + 1)) {
                        upDown += 1;
                    }
                    break;

                case "down":
                    if (-(board[1] / 2) <= (upDown - 1)) {
                        upDown -= 1;
                    }
                    break;
            }
        }
        return new int[]{leftRight, upDown};
    }
}
