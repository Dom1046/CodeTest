package code.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//막대기
public class CodeTest33 {
    //핵심 로직
    public static List<Integer> polls = new ArrayList<>();
    public static int poll = 64;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        //1차 막대 크기 X보다 작게하기
        makeSmaller(X);
        //자른 막대 한번 넣어주기
        polls.add(poll);
        //X와 붙인 막대기 크기 비교하며, 계속 자르기
        makeSmaller2(X);
        // 막대기 수 반환
        System.out.println(polls.size());
    }

    //막대 절반으로 자르기
    public static int cutHalf(int poll){
        return poll/2;
    }
    //막대 붙여보기
    public static int attachPolls(){
        //막대 모두 붙이기
        return polls.stream().reduce(0, Integer::sum);
    }
    //막대 사이즈 작게 만들기
    public static void makeSmaller(int X){
        if (poll > X){
            poll = cutHalf(poll);
        }else return;
        makeSmaller(X);
    }
    //막대 사이즈 작게 만들기
    public static void makeSmaller2(int X){
        //X와 길이가 같으면 나가기
        if (attachPolls() == X) {
            return;
        }
        // 막대 자르기
        poll = cutHalf(poll);
        // X - 붙인 막대길이
        int rest = X - attachPolls();

        // 만약 rest가 현재 poll보다 크거나 같다면 이 poll도 붙여야 함
        if (rest >= poll) {
            polls.add(poll);
        }
        // 다시 검사
        makeSmaller2(X);
    }

}
