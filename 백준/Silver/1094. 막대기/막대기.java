import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    //핵심 로직
    public static List<Integer> polls = new ArrayList<>();
    public static int poll = 64;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        // X보다 작게 만들기 (poll <= X)
        makeSmaller(X);
        // 재귀를 이용해 남은 길이만큼 필요한지 체크하며 자르고 붙이기
        polls.add(poll); // 처음 poll은 이미 X보다 작거나 같으므로 일단 붙여둔다
        makeSmaller2(X);
        // 붙인 막대 수 출력
        System.out.println(polls.size());
    }

    // 막대를 절반으로 자르기
    public static int cutHalf(int poll) {
        return poll / 2;
    }

    // 지금까지 붙인 막대들의 합을 구하기
    public static int attachPolls() {
        return polls.stream().reduce(0, Integer::sum);
    }

    // poll을 X보다 작거나 같게 만들기
    public static void makeSmaller(int X) {
        // poll이 X보다 클 동안 계속 절반으로 자른다
        if (poll > X) {
            poll = cutHalf(poll);
            makeSmaller(X);
        } 
        // poll <= X면 종료
    }

    // 재귀적으로 남은 길이를 확인하며 poll을 자르고, 필요하면 붙이는 로직
    public static void makeSmaller2(int X) {
        // base condition: 이미 X만큼 붙였으면 종료
        if (attachPolls() == X) {
            return;
        }

        // poll을 절반으로 자른다
        poll = cutHalf(poll);
        // 지금까지 붙인 막대 합
        int sum = attachPolls();
        // 필요한 나머지 길이
        int rest = X - sum;

        // 만약 rest가 현재 poll보다 크거나 같다면 이 poll도 붙여야 함
        if (rest >= poll) {
            polls.add(poll);
        }
        // 다시 검사
        makeSmaller2(X);
    }
}