class Solution {
    public int[] solution(int N, int[] stages) {
        return sortFailure(getFailure(N, stages));
    }

    //실패율 구하기
    public double[][] getFailure(int N, int[] stages){
        // 실패율 = [ {스테이지 번호, 실패율}, {}, {} ]
        double[][] failure = new double[N][2];
        int cnt = 0;
        int players = stages.length;
        // 실패 플레이어 수
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < stages.length; j++) {
                if (i == stages[j]) {
                    cnt++;
                }
            }
            // 실패율 = 실패 플레이어 수 / 총 플레이어 수
            failure[i - 1][0] = i;
            failure[i - 1][1] = (double)cnt/players;
            //변수 최신화
            players = players - cnt;
            cnt = 0;
        }
        return failure;
    }

    //실패율 내림차순 정렬 (실패율 같을 시 -> 스테이지 번호 오름차순으로)
    public int[] sortFailure(double[][] failure){
        int[] answer = new int[failure.length];
        for (int i = 0; i < failure.length; i++) {
            for (int j = i + 1; j < failure.length; j++) {
                //실패율 큰게 앞으로
                if (failure[i][1] < failure[j][1]) {
                    double[] temp = failure[i];
                    failure[i] = failure[j];
                    failure[j] = temp;
                }
                //실패율 같을 시
                if (failure[i][1] == failure[j][1]) {
                    if(failure[i][0] > failure[j][0]){
                        double[] temp = failure[i];
                        failure[i] = failure[j];
                        failure[j] = temp;
                    }
                }
            }
        }
        //일차 배열로 스테이지 번호 옮기기
        for (int i = 0; i < answer.length; i++) {
            answer[i] = (int)failure[i][0];
        }
        return answer;
    }
}