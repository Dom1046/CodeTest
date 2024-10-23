package code.test;

import java.util.LinkedList;
import java.util.Queue;
// 소수만들기
public class CodeTest8 {
    public int solution(int[] nums) {
        int cnt = 0;
        // 속도 빠른 큐 사용
        Queue<Integer> queue = new LinkedList<>();
        plusNums(nums, queue);
        // 큐 빌 때 까지
        while (!queue.isEmpty()) {
            if (checkNum(queue.poll())) {
                cnt++;
            }
        }
        return cnt;
    }
    // 3개 수의 합 더하기 큐에 넣기
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
    // 소수인지 확인하기
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

    public static void main(String[] args) {
        CodeTest8 test = new CodeTest8();
        int[] nums = new int[]{1, 2, 3, 4};
        int result = test.solution(nums);
        System.out.println(result);
    }
}
