import java.util.*;

class Solution{
    public int solution(int n, int a, int b) {
        // n이 0일 상황 대비
        if (n == 0) {
            return 0;
        }
        int answer = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        while (list.size() > 1) {
            List<Integer> nextRound = new ArrayList<>();
            for (int i = 0; i < list.size(); i += 2) {
                int p1 = list.get(i);
                int p2 = list.get(i + 1);

                if ((p1 == a && p2 == b) || (p1 == b && p2 == a)) {
                    return answer + 1;
                }

                if (p1 == a || p1 == b) {
                    nextRound.add(p1);
                } else if (p2 == a || p2 == b) {
                    nextRound.add(p2);
                } else {
                    nextRound.add(p1);
                }
            }
            list = nextRound;
            answer++;
        }
        return answer+1;
    }
}