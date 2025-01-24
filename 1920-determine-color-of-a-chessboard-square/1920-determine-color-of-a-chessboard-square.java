class Solution {
    public boolean squareIsWhite(String coordinates) {
        char[] block = coordinates.toCharArray();
        boolean answer = false;

        if((block[0] - 96) % 2 != 0){
            if(block[1] % 2 != 0){
                answer = false;
            }else answer = true;
        }else {
            if(block[1] % 2 !=  0){
                answer = true;
            }else answer = false;
        }
        return answer;
    }
}