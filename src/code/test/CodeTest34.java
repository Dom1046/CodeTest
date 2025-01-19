package code.test;

import java.util.*;

//사격 내기
public class CodeTest34 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int scoreA = sc.nextInt();
        int scoreB = sc.nextInt();

        List<Integer> scoreC = new ArrayList<>();
        scoreC = getEachScores(scoreA, scoreC);
        scoreC = getEachScores(scoreB, scoreC);
        int totalScore = getTotalScore(scoreC);

        //정답
        System.out.println(totalScore);
    }
    public static List<Integer> getEachScores(int score, List<Integer> scoreC) {
        while (score > 0) {
            // 맞춘 과녁 찾기
            int eachScore = getSquare(score);
            // 과녁점수 C에 넣기
            scoreC = checkDuplicates(scoreC, eachScore);
            // 점수에서 과녁점수 빼기
            score -= eachScore;
        }
        return scoreC;
    }

    //점수보다 바로 낮은 2의 거듭제곱 만들기
    public static int getSquare(int score){
        int square = 1;
        do {
            square *= 2;
        } while (square <= score);
        return square/2;
    }

    //scoreC의 총점 구하는 메서드
    public static int getTotalScore(List<Integer> scoreC){
        return scoreC.stream().reduce(0, Integer::sum);
    }

    //점수가 존재하면 지우고, 없다면 추가하기
    public static List<Integer> checkDuplicates(List<Integer> scoreC, int score){
        if (scoreC.contains(score)) {
            scoreC.remove(Integer.valueOf(score));
        }else scoreC.add(score);
        return scoreC;
    }
}
