package code.test;

import java.util.Scanner;

//하얀 칸
public class CodeTest35 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] chessBoard = new String[8];
        int index = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            chessBoard[index] = line;
            index++;
            if (index == 8){
                break;
            }
        }
        int cnt = 0;

        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = (i%2==0)? 0:1; j < chessBoard.length; j +=2) {
                char whiteBlock = chessBoard[i].charAt(j);
                if (whiteBlock == 'F'){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
