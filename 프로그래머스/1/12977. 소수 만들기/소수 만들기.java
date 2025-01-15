import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        plusNums(nums, queue);
        
        // 큐가 빌 때까지 poll()을 사용
        while (!queue.isEmpty()) {
            if (checkNum(queue.poll())) {
                cnt++;
            }
        }
        return cnt;
    }
    
    public Queue<Integer> plusNums(int[] nums, Queue<Integer> queue) {
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    queue.offer(nums[i] + nums[j] + nums[k]);
                }
            }
        }
        return queue;
    }

    public boolean checkNum(int num) {
        for (int i = 1; i <= num / 2; i++) {
            for (int j = 1; j < num; j++) {
                if (i * i == num) {
                    return false;
                }if (i * j == num) {
                    return false;
                }
            }
        }
        return true;
    }
}