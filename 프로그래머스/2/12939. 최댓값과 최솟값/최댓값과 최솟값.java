class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] nums = s.split(" ");
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Integer.parseInt(nums[i]) > Integer.parseInt(nums[j])) {
                    String temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        answer.append(nums[0]);
        answer.append(" ");
        answer.append(nums[nums.length - 1]);
        return answer.toString();
    }
}