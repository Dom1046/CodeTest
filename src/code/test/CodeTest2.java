package code.test;

import java.util.ArrayList;
import java.util.List;
//로또 번호
public class CodeTest2 {
    public int[] solution(int[] lottos, int[] win_nums) {
        List<Integer> matchedNum = new ArrayList<>();
        List<Integer> zeros = new ArrayList<>();
        int[] answer = new int[2];
        for (int lotto : lottos) {
            for (int winNum : win_nums) {
                if (lotto == winNum) {
                    matchedNum.add(lotto);
                }
            }
            if (lotto == 0) {
                zeros.add(lotto);
            }
        }
        answer[1] = calcRank(matchedNum);
        matchedNum.addAll(zeros);
        answer[0] = calcRank(matchedNum);

        return answer;
    }
    public int calcRank(List<Integer> numList){
        int numCount = numList.size();
        if (numCount == 0) return 6;
        return 7 - numCount;
    }
}
