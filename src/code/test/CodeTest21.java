package code.test;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
// 미로탈출
public class CodeTest21 {
    // 동,서,남,북 위치 이동 x축, y 축
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();

        Point start = null, lever = null, exit = null;

        // 미로 위치 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) == 'S') start = new Point(i, j);
                if (maps[i].charAt(j) == 'L') lever = new Point(i, j);
                if (maps[i].charAt(j) == 'E') exit = new Point(i, j);
            }
        }

        // BFS 탐색
        int toLever = bfs(maps, start, lever, n, m);
        if (toLever == -1) return -1;

        int toExit = bfs(maps, lever, exit, n, m);
        if (toExit == -1) return -1;

        return toLever + toExit;
    }

    private int bfs(String[] maps, Point start, Point target, int n, int m) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        queue.offer(start);
        visited[start.x][start.y] = true;
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point current = queue.poll();
                if (current.equals(target)) return steps;

                for (int d = 0; d < 4; d++) {
                    int nx = current.x + dx[d];
                    int ny = current.y + dy[d];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m &&
                            maps[nx].charAt(ny) != 'X' && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
            steps++;
        }
        return -1; // 도달 불가
    }
}

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point point = (Point) obj;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
