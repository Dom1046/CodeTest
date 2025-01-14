import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Boolean> map = new HashMap<>();

        for( int i = 0; i < numbers.length; i++){
            for( int j = i + 1; j < numbers.length; j++){
                int num = numbers[i] + numbers[j];
                if (map.isEmpty()){
                    answer.add(num);
                    map.put(num, true);
                }
                if (map.get(num) == null){
                    answer.add(num);
                    map.put(num, true);
                }
            }
        }
        Collections.sort(answer);
        return answer.stream().mapToInt(i -> i).toArray();
    }
}