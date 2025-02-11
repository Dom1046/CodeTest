import java.util.*;
class Main{
    static int[][] board = new int[5][5];  // 5x5 숫자판
    static Set<String> uniqueNumbers = new HashSet<>(); // 중복 방지를 위한 HashSet
    static int[] dx = {-1, 1, 0, 0};  // 상하좌우 이동
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 숫자판 입력 받기
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = sc.nextInt();  // nextInt()를 사용하여 숫자 하나씩 읽기
            }
        }
        sc.close();  // 사용이 끝난 Scanner 닫기

        // 모든 위치에서 탐색 시작
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, "", 0);
            }
        }

        // 서로 다른 6자리 숫자의 개수 출력
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