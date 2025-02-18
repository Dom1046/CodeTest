package code.test;

import java.util.*;

public class CodeTest50 {
    public int[] solution(int n, String[] words) {
        Set<String> saidWords = new HashSet<>();
        String theWord = words[0];
        saidWords.add(theWord);

        for(int i = 1; i < words.length; i++){
            String word = words[i];

            if(saidWords.contains(word)){
                return new int[]{i%n+1, i/n+1};
            }
            if (!word.startsWith(theWord.substring(theWord.length() - 1))) {
                return new int[]{i % n + 1, i / n + 1};
            }
            saidWords.add(word);
            theWord = word;
        }
        return new int[]{0,0};
    }

    public static void main(String[] args) {
        CodeTest50 test = new CodeTest50();

        // Test case 1
        System.out.println("Test case 1: ");
        System.out.println(Arrays.toString(test.solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));

        // Test case 2
        System.out.println("Test case 2: ");
        System.out.println(Arrays.toString(test.solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"})));

        // Test case 3
        System.out.println("Test case 3: ");
        System.out.println(Arrays.toString(test.solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"})));
    }
}
