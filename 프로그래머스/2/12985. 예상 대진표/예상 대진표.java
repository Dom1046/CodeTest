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
            //다음 라운드 대진표
            List<Integer> nextRound = new ArrayList<>();
            // 2씩 증가 시키기
            for (int j = 0; j < list.size(); j += 2) {

                //(1,2) (3,4) 대진붙이기
                int p1 = list.get(j);
                int p2 = list.get(j + 1);

                //( 4,7 )만나면 break; 하기
                if ((list.get(j) == a || list.get(j) == b) &&
                        (list.get(j + 1) == a || list.get(j + 1) == b)) {
                    index++;
                    break;
                }
                // a, b 무조건 이기게 하기
                // a 혹은 b가 발견되면 다음라운드 진출
                if (list.get(j) == a || list.get(j) == b) {
                    nextRound.add(p1);
                } else if (list.get(j + 1) == a || list.get(j + 1) == b) {
                    nextRound.add(p2);
                    //둘다 해당안되면 아무나 다음라운드 진출시키기
                }else nextRound.add(p1);
            }
            //다음 라운드로 list 교체시키기
            list = nextRound;
            if (index == 1) break;
            answer++;
        }
        //둘이 만났을 때 경기 횟수 1번 추가해주기
        return answer + 1;
    }

    //제곱근 구하기 (2보다 작으면 빠져나가기)
    public int getSquare(int n) {
        int cnt = 0;
        while (n > 1) {
            n /= 2;
            cnt++;
        }
        return cnt;
    }
}