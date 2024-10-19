package code.test;

import java.util.ArrayList;
import java.util.List;

public class CodeTest6 {
    //필요 자료구조 및 int 변수
    static int countA = 0;
    static int countB = 0;
    static int index = 1;
    static int result = 0;
    static List<Character> list = new ArrayList<>();

    // 메서드
    public int solution(String s) {
        stringToChar(s);
        return divideArray();
    }
    // 문자열 문자로 변환
    public void stringToChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }
    }
    // 핵심 로직
    public int divideArray() {
        for (int i = 0; i < list.size();) {
            if (list.get(0) == list.get(i)) countA++;
            else countB++;
            index = 1;
            i++;
            if (countA == countB) {
                for (int j = 0; j < i; j++) {
                    list.remove(0);
                    if (list.isEmpty()) {
                        index = 0;
                        break;
                    }
                }
                i = 0;
                countA = 0;
                countB = 0;
                result++;
            }
        }
        return result+index;
    }

    public static void main(String[] args) {
        String s = "aaabbaccccabba";
        CodeTest6 test = new CodeTest6();
        System.out.println("test.solution(s) = " + test.solution(s));
    }
}
