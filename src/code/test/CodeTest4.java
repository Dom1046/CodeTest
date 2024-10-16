package code.test;

import java.util.Arrays;

//공원 산책
public class CodeTest4 {
    // 공원 산책
    public int[] solution(String[] park, String[] routes) {
        // 공원배열
        int n = park.length;
        int m = park[0].length();
        char[][] parkArray = new char[n][m];

        //명령배열
        int r = routes.length;
        int s = routes[0].length();
        char[][] routeArray = new char[r][3];

        // 2중 for문 나가기 위한 제어장치
        boolean exit = false;

        // 현재 위치
        int lastPositionW = 0;
        int lastPositionH = 0;

        // 공원 배열로 만들기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                parkArray[i][j] = park[i].charAt(j);
            }
        }

        // 방향 구분하기
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < s; j++) {
                routeArray[i][j] = routes[i].charAt(j);
            }
        }

        // 시작지점 찾기
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isStart(i, j, parkArray)) {
                    lastPositionW = j;
                    lastPositionH = i;
                    exit = true;
                    break;
                }
            }
            if (exit) break;
        }
        // 실행 로직
        for (int i = 0; i < r; i++) { // 명령 확인
            int side = moveWidth(i, routeArray);
            int upDown = moveHeight(i, routeArray);

            // 장애물, 배열 넘는지 확인
            if (m > lastPositionW + side && n > lastPositionH + upDown && lastPositionW + side >= 0 && lastPositionH + upDown >= 0) {
                if (side != 0) {
                    if (!isBlockSide(lastPositionW, lastPositionH, parkArray, side)) {
                        //장애물 있을 시 스킵
                        continue;
                    }
                    lastPositionW += side;
                }
                if (upDown != 0) {
                    if (!isBlockHeight(lastPositionW, lastPositionH, parkArray, upDown)) {
                        continue;
                    }
                    lastPositionH += upDown;
                }
            }
        }
        return new int[]{lastPositionH, lastPositionW};
    }

    // 시작지점 찾기
    public boolean isStart(int x, int y, char[][] parkArray) {
        if (parkArray[x][y] == 'S') {
            return true;
        }
        return false;
    }

    // 장애물 식별하기 가로
    public boolean isBlockSide(int x, int y, char[][] parkArray, int side) {
        if (side > 0) {
            for (int i = x; i <= x + side; i++) {
                if (parkArray[y][i] == 'X') {
                    return false;
                }
            }
        }
        if (side < 0) {
            for (int i = x; i >= x + side; i--) {
                if (parkArray[y][i] == 'X') {
                    return false;
                }
            }
        }
        return true;
    }

    // 장애물 식별하기 세로
    public boolean isBlockHeight(int x, int y, char[][] parkArray, int height) {
        if (height > 0) {
            for (int j = y; j <= y + height; j++) {
                if (parkArray[j][x] == 'X') {
                    return false;
                }
            }
        }
        if (height < 0) {
            for (int j = y; j >= y + height; j--) {
                if (parkArray[j][x] == 'X') {
                    return false;
                }
            }
        }
        return true;
    }

    // 명령 식별하기 가로
    public int moveWidth(int x, char[][] routeArray) {
        if (routeArray[x][0] == 'E') {
            return Character.getNumericValue(routeArray[x][2]);
        }
        if (routeArray[x][0] == 'W') {
            return -Character.getNumericValue(routeArray[x][2]);
        }
        return 0;
    }

    // 명령 식별하기 세로
    public int moveHeight(int x, char[][] routeArray) {
        if (routeArray[x][0] == 'S') {
            return Character.getNumericValue(routeArray[x][2]);
        }
        if (routeArray[x][0] == 'N') {
            return -Character.getNumericValue(routeArray[x][2]);
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] park = new String[]{"OXO", "XSX", "OXO"};
        String[] routes = new String[]{"S 1", "E 1", "W 1", "N 1"};
        code.test.CodeTest4 codeTest4 = new code.test.CodeTest4();
        System.out.println(Arrays.toString(codeTest4.solution(park, routes)));
    }
}
