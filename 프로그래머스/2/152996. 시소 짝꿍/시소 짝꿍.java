import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;

        // 같은 몸무게들을 모으기
        //ex) map = { (100, 5), (200, 6), (150, 7) }
        Map<Integer, Long> countMap = new HashMap<>();
        for (int weight : weights) {
            // 없다면, 0 저장, 존재한다면 +1
            countMap.put(weight, countMap.getOrDefault(weight, 0L) + 1);
        }

        // 가능한 비율을 분자와 분모로 표현
        // 이렇게 하지 않으면, 하드코딩으로 코드가 지저분함
        int[][] ratios = {
                {1, 1},
                {1, 2}, {2, 1},
                {2, 3}, {3, 2},
                {3, 4}, {4, 3}
        };

        // 각 몸무게에 대해 가능한 짝꿍 몸무게를 찾음
        for (int weight : countMap.keySet()) {
            for (int[] ratio : ratios) {
                int son = ratio[0];
                int mother = ratio[1];
                long weightSon = (long) weight * son;

                int targetWeight = (int) (weightSon / mother);

                
                // 대상 몸무게가 정수가 아닌 경우 스킵
                if (weightSon % mother != 0) {
                    continue;
                }
                
                // 대상 몸무게가 존재하지 않으면 스킵
                if (!countMap.containsKey(targetWeight)) continue;

                // 중복 카운팅 방지
                //{ 100, 150, 200 }
                // 100 & 150 -> 100 * 2 | 150 * 3
                // 경우의 수 : 6
                // 150 & 100은 continue
                if (weight > targetWeight) continue;

                // 동일한 몸무게인 경우 조합 계산 nCr = n! / (n-r)!r!
                // nC2 = n(n-1)(n-2)! / (n-2)!2!
                // nC2 = n(n-1) / 2
                // { 100, 100, 100 }인 경우
                // 3C2 = 3(3-1) /2 = 3
                // 경우의 수 : 3
                if (weight == targetWeight) {
                    long count = countMap.get(weight);
                    answer += count * (count - 1) / 2;
                } else {
                    // 다른 몸무게인 경우 쌍의 수 계산
                    // { 100, 100, 200, 200, 200 }
                    // 100 * 2 | 200 * 3
                    // 2 * 3 = 6
                    // 경우의 수 : 6
                    answer += countMap.get(weight) * countMap.get(targetWeight);
                }
            }
        }

        return answer;
    }
}