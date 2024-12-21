package code.test;

import java.util.*;

//당구연습
public class codeTest23 {

    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {

        int[] results = new int[balls.length];
        List<Integer> ballList = new ArrayList<>();

        for (int i = 0; i < balls.length; i++) {
            int ballX = balls[i][0];
            int ballY = balls[i][1];

            // 1) 좌벽
            int leftDist = leftSideBoard(startX, startY, ballX, ballY);
            // 만약 '벽까지 가는 경로'에 공이 먼저 있으면 배제(-1)
            if (!isCollideBeforeWall(startX, startY, ballX, ballY,
                    -ballX, ballY)) {
                ballList.add(leftDist);
            }
            // 2) 우벽
            int rightDist = rightSideBoard(startX, startY, ballX, ballY, m);
            if (!isCollideBeforeWall(startX, startY, ballX, ballY,
                    2*m - ballX, ballY)) {
                ballList.add(rightDist);
            }

            // 3) 상벽
            int upDist = upperSideBoard(startX, startY, ballX, ballY);
            if (!isCollideBeforeWall(startX, startY, ballX, ballY,
                    ballX, 2*n - ballY)) {
                ballList.add(upDist);
            }

            // 4) 하벽
            int downDist = bottomSideBoard(startX, startY, ballX, ballY, n);
            if (!isCollideBeforeWall(startX, startY, ballX, ballY,
                    ballX, -ballY)) {
                ballList.add(downDist);
            }

            Integer min = ballList.isEmpty()? 0 : Collections.min(ballList);
            results[i] = min;
            ballList.clear();
        }
        return results;
    }

    //좌변 거리 구하는 메서드
    public int leftSideBoard(int startX, int startY, int ballX, int ballY) {
        int side = square(startX + ballX);
        if (startY > ballY) {
            return side + square(startY - ballY);
        }
        return side + square(ballY - startY);
    }

    //우변 거리 구하는 메서드
    public int rightSideBoard(int startX, int startY, int ballX, int ballY, int m) {
        int side = square((m - startX) + (m - ballX));
        if (startY > ballY) {
            return side + square(startY - ballY);
        }
        return side + square(ballY - startY);
    }

    //상변 거리 구하는 메서드
    public int upperSideBoard(int startX, int startY, int ballX, int ballY) {
        int side = square(startY + ballY);
        if (startX > ballX) {
            return side + square(startX - ballX);
        }
        return side + square(ballX - startX);
    }

    //하변 거리 구하는 메서드
    public int bottomSideBoard(int startX, int startY, int ballX, int ballY, int n) {
        int side = (square((n - startY) + (n - ballY)));
        if (startX > ballX) {
            return side + square(startX - ballX);
        }
        return side + square(ballX - startX);
    }

    //제곱 구해주는 메서드
    public int square(int num) {
        return num * num;
    }

    //쳐야할 길에 공이 존재하는지 여부 확인 메서드
    private boolean isCollideBeforeWall(int sX, int sY,
                                        int bX, int bY,
                                        int refX, int refY) {
        // 1) 일직선인지 확인
        int cross1 = (refX - sX) * (bY - sY);
        int cross2 = (refY - sY) * (bX - sX);
        if (cross1 != cross2) {
            return false;
        }

        // 2) 공이 길에 있는지 확인
        if (isBetween(sX, refX, bX) && isBetween(sY, refY, bY)) {
            return true;
        }

        return false;
    }

    private boolean isBetween(int a, int b, int c) {
        return (c >= Math.min(a, b) && c <= Math.max(a, b));
    }
}
