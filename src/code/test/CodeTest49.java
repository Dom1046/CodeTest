package code.test;

import java.io.*;
import java.util.Random;

//숫자판 점프
public class CodeTest49 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String answer;

        final int[][] Direction = {
                {-1, 0}, // 위쪽
                {1, 0},  // 아래쪽
                {0, -1}, // 왼쪽
                {0, 1}   // 오른쪽
        };

        String[][] board = new String[5][5];

        for (int i = 0; i < 5; i++) {
            board[i] = reader.readLine().split(" ");
        }

        for (int i = 0; i < 6; i++) {
            int rows = 5;
            int cols = 5;
            int startX = (int)(Math.random()*5);
            int startY = (int)(Math.random()*5);

            for (int[] dir : Direction) {

                int newX = startX + dir[0];
                int newY = startY + dir[1];

                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols) {
                    startX = newX;
                    startY = newY;
                }
            }
            writer.append(startX + " " + startY);
        }


        writer.flush();
    }
}
