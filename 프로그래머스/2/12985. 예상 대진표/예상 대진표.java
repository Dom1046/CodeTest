import java.util.*;

class Solution{
    public int solution(int n, int a, int b) {
        // n이 0일 상황 대비
        if (n == 0) {
            return 0;
        }
        int answer = 0;
        int index = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        // 2^n n값 구하기
        int m = getSquare(n);


        for (int i = 0; i < m; i++) {
            List<Integer> nextRound = new ArrayList<>();
            for (int j = 0; j < list.size()-1; j += 2) {
                int p1 = list.get(j);
                int p2 = list.get(j + 1);
                if ((list.get(j) == a || list.get(j) == b) &&
                        (list.get(j + 1) == a || list.get(j + 1) == b)) {
                    index++;
                    break;
                }

                if (list.get(j) == a || list.get(j) == b) {
                    nextRound.add(p1);
                } else if (list.get(j + 1) == a || list.get(j + 1) == b) {
                    nextRound.add(p2);
                }else nextRound.add(p1);
            }
            list = nextRound;
            if (index == 1) break;
            answer++;
        }
        return answer+1;
    }

    public int getSquare(int n) {
        int cnt = 0;
        while (n > 1) {
            n /= 2;
            cnt++;
        }
        return cnt;
    }
}