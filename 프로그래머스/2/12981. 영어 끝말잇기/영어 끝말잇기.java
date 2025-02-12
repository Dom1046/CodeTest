import java.util.*;

class Solution {
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

}