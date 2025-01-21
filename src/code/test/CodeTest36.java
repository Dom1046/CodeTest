package code.test;

import java.util.Arrays;
import java.util.Scanner;

//4_LSB
public class CodeTest36 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[3];

        for (int i = 0; i < 3; i++){
            int num = sc.nextInt();
            nums[i] = num;

            if (i == 2) {
                System.out.println(Arrays.toString(nums));
                int answer = nums[0]|nums[1]|nums[2];
                System.out.println(nums[0]+" "+ nums[1]+" "+ nums[2]);
                //비밀번호 자릿수 구하기
                int answersNum = getNums(answer);
                //앞에 4자리가 될 때까지 0채우기
                System.out.println(addZero(answersNum, answer));
            }
        }
    }
    //자릿수 구하기
    public static int getNums(int answer){
        int cnt = 0;
        while(answer > 0){
            answer = answer / 10;
            cnt++;
        }
        return cnt;
    }
    //앞에 0넣어주기
    public static int addZero(int answersNum, int answer){
        for (int i = 0; i < 4 - answersNum; i++){
            answer = Integer.parseInt("0" + answer);
        }
        return answer;
    }
}
