package code.grammarTest;

import java.util.*;

//map
public class GramTest {
    public static void main(String[] args) {
        Map<Integer,String> map = new Hashtable<>();
        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"c");
        map.put(4,"d");

        boolean a = map.entrySet().contains(new AbstractMap.SimpleEntry<>(1, "a"));
        // 출력값 => true

        // 엔트리들을 값 받아와 Set에 넣기
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry<Integer,String> entry: entries){
            entry.setValue("F"); // value의 값을 바꾸면 된다.
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println("key = " + key);
            System.out.println("value = " + value);
        }

        System.out.println("map.get(1) = " + map.get(1));
        // 출력값 => map.get(1) = F

        Map<Integer, String> hashtable = new Hashtable<>();
        hashtable.put(1, "안녕");
        hashtable.put(2, "안녕2");

        Set<Map.Entry<Integer, String>> entries1 = hashtable.entrySet();
        for (Map.Entry<Integer,String> entry: entries1){
            entry.setValue("F");
        }


    }
}
