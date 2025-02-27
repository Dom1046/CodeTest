import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int[] firstPart = Arrays.copyOfRange(arr, intervals[0][0], intervals[0][1] + 1);
        int[] secondPart = Arrays.copyOfRange(arr, intervals[1][0], intervals[1][1] + 1);
        
        int[] result = new int[firstPart.length + secondPart.length];
        System.arraycopy(firstPart, 0, result, 0, firstPart.length);
        System.arraycopy(secondPart, 0, result, firstPart.length, secondPart.length);
        
        return result;
    }
}
