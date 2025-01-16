package code.test;

import java.util.*;
import java.util.stream.Collectors;

public class CodeTest31 {
    public int[] solution(int[] numbers) {
        Set<Integer> answerHash = new HashSet<>();

        for( int i = 0; i < numbers.length; i++){
            for( int j = i + 1; j < numbers.length; j++){
                int num = numbers[i] + numbers[j];
                    answerHash.add(num);
            }
        }
        List<Integer> answer = new ArrayList<>(answerHash);
        Collections.sort(answer);
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
