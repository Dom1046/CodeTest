import java.util.*;

class Solution {
   public int[] solution(int m, int n, int startX, int startY, int[][] balls) {

        // 결과 배열 초기화 (각 공마다 최소 거리 제곱값 저장)
        int[] results = new int[balls.length];

        for (int i = 0; i < balls.length; i++) {
            int ballX = balls[i][0]; // 목표 공의 X 좌표
            int ballY = balls[i][1]; // 목표 공의 Y 좌표

            // 8가지 거울 좌표를 계산
            int[][] mirrors = {
                    {-ballX, ballY},            // 좌벽 반사
                    {2*m - ballX, ballY},       // 우벽 반사
                    {ballX, 2*n - ballY},       // 상벽 반사
                    {ballX, -ballY}             // 하벽 반사
            };

            // 가능한 모든 거리 제곱값 저장
            List<Integer> ballList = new ArrayList<>();

            for (int[] ref : mirrors) {
                int refX = ref[0]; // 반사점 X 좌표
                int refY = ref[1]; // 반사점 Y 좌표

                // 시작점 -> 반사점 거리^2
                int distSq = square(startX - refX) + square(startY - refY);

                // 중간에 목표 공이 있는 경우 무효화 처리
                if (!isCollideBeforeWall(startX, startY, ballX, ballY, refX, refY)) {
                    ballList.add(distSq);
                }
            }

            // 후보 중 최소 거리 제곱값
            results[i] = ballList.isEmpty() ? 0 : Collections.min(ballList);
        }

        return results;
    }

    // 제곱 계산 메서드
    public int square(int num) {
        return num * num;
    }

    // 시작점 -> 반사점 경로에 공이 존재하는지 확인
    private boolean isCollideBeforeWall(int startX, int startY,
                                        int ballX, int ballY,
                                        int refX, int refY) {

        // 1-1) 세 점이 일직선인지 확인 (기울기 성질 이용)
        double cross1 = (double) (ballY - startY) / (ballX - startX);
        double cross2 = (double) (refY - ballY) / (refX - ballX);
        if (cross1 != cross2) {
            return false; // 일직선이 아님
        }

        // 2) 목표 공이 경로 중간에 있는지 확인
        if (isBetween(startX, refX, ballX) && isBetween(startY, refY, ballY)) {
            return true; // 공이 경로 상에 존재
        }

        return false; // 공이 경로 상에 없음
    }

    // 범위 내에 값이 존재하는지 확인 (경계 포함)
    private boolean isBetween(int a, int b, int c) {
        return (c >= Math.min(a, b) && c <= Math.max(a, b));
    }

}