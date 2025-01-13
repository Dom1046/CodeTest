class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        //지원요청비 오름차순 정령
        for (int i = 0; i < d.length; i++) {
            for (int j = i + 1; j < d.length; j++) {
                if (d[i] > d[j]) {
                    int temp = d[i];
                    d[i] = d[j];
                    d[j] = temp;
                }
            }
        }
        //예산 - 요청 지원비
        for (int i = 0; i < d.length; i++) {
            if (budget >= d[i]){
                budget -= d[i];
                answer++;
            } else break;
        }
        return answer;
    }
}