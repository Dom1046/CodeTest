package code.grammarTest;

import java.util.HashMap;
import java.util.Map;

//의상
// 다른 사람의 해설 참고함.
public class CodeTest10 {
    public int solution(String[][] string) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] str : string) {
            String type = str[1];
            map.put(type, map.getOrDefault(type, 0) + 1);

        }
        int sum = 1;
        var iter = map.values().iterator();
        while (iter.hasNext()) {
            sum *= iter.next() + 1;
        }
        return sum - 1;
    }
}
