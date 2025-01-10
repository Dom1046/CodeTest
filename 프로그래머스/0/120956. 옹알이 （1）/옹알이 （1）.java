class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] dictionary = {"aya", "ye", "woo", "ma"};
        for (String bab : babbling) {
            for (String word : dictionary) {
                bab = bab.replace(word, " ");
            }
            if (bab.trim().isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}