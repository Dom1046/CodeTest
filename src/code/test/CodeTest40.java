package code.test;

import java.util.*;

//데이터 분석
public class CodeTest40 {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String, Integer> words = new HashMap<>();
        words.put("code", 0);
        words.put("date", 1);
        words.put("maximum", 2);
        words.put("remain", 3);

        List<int[]> list = new ArrayList<>();
        for (int[] datum : data) {
            if (datum[words.get(ext)] < val_ext) {
                list.add(datum);
            }
        }
        list.sort(Comparator.comparingInt(a -> a[words.get(sort_by)]));
        return list.toArray(new int[list.size()][]);
    }
}
