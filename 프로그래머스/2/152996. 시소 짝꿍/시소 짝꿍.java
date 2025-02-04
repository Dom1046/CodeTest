import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;

        // 몸무게의 빈도수를 저장할 Map
        Map<Integer, Long> countMap = new HashMap<>();
        for (int weight : weights) {
            countMap.put(weight, countMap.getOrDefault(weight, 0L) + 1);
        }

        // 가능한 비율을 분자와 분모로 표현
        int[][] ratios = {
            {1,1},
            {1,2}, {2,1},
            {2,3}, {3,2},
            {3,4}, {4,3}
        };

        // 각 몸무게에 대해 가능한 짝꿍 몸무게를 찾음
        for (int weight : countMap.keySet()) {
            for (int[] ratio : ratios) {
                int numerator = ratio[0];
                int denominator = ratio[1];
                long multipliedWeight = (long) weight * numerator;

                // 대상 몸무게가 정수가 아닌 경우 스킵
                if (multipliedWeight % denominator != 0) {
                    continue;
                }

                int targetWeight = (int)(multipliedWeight / denominator);

                // 몸무게는 100 이상 1000 이하
                if (targetWeight < 100 || targetWeight > 1000) continue;

                // 대상 몸무게가 존재하지 않으면 스킵
                if (!countMap.containsKey(targetWeight)) continue;

                // 중복 카운팅 방지
                if (weight > targetWeight) continue;

                // 동일한 몸무게인 경우 조합 계산
                if (weight == targetWeight) {
                    long count = countMap.get(weight);
                    answer += count * (count - 1) / 2;
                } else {
                    // 다른 몸무게인 경우 쌍의 수 계산
                    answer += countMap.get(weight) * countMap.get(targetWeight);
                }
            }
        }

        return answer;
    }
}