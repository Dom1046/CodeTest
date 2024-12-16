package code.test;

import java.util.ArrayList;

//혼자서 하는 틱택토
public class codeTest22 {
    ArrayList<String> every=new ArrayList<>();
    public void dfs(String s,int progress){

        char[][] grid = new char[3][3];

        for (int i = 0; i < 9; i++) {
            grid[i / 3][i % 3] = s.charAt(i);
        }

        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] != '.' && grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) {
                return ;
            }
            if (grid[0][i] != '.' && grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i]) {
                return ;
            }
        }

        // Check diagonals
        if (grid[0][0] != '.' && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
            return ;
        }
        if (grid[0][2] != '.' && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) {
            return ;
        }

        for(int i=0;i<9;i++){
            if(s.charAt(i)=='.' && progress%2==0){//O차례
                StringBuilder tempA=new StringBuilder(s);
                tempA.setCharAt(i,'O');

                every.add(tempA.toString());
                dfs(tempA.toString(),progress+1);


            }
            else if(s.charAt(i)=='.' && progress%2==1){//X차례
                StringBuilder tempA=new StringBuilder(s);
                tempA.setCharAt(i,'X');
                every.add(tempA.toString());
                dfs(tempA.toString(),progress+1);

            }
        }
    }

    public int solution(String[] board) {
        int answer = -1;

        StringBuilder whole=new StringBuilder("");

        for(int i=0;i<board.length;i++){
            whole.append(board[i]);
        }

        dfs(".........",0);
        every.add(".........");

        if(every.contains(whole.toString())){
            answer=1;
        }else{
            answer=0;
        }
        return answer;
    }
}
