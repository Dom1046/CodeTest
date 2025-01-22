package code.test;

import java.util.Scanner;

//4_LSB
public class CodeTest36 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = new String[3];

        for (int i = 0; i < 3; i++){
            //하위 4자리 구하기
            nums[i] = getDigit4(sc.nextInt());

            if (i == 2) {
                //세 비밀번호 합치기
                String answer = attachNums(nums);
                //이진수 십진수로 바꾸기
                int answerInt = Integer.parseInt(answer, 2);
                //비밀번호 자릿수 구하기
                int digitCnt = getDigitCnt(answerInt);
                //비밀번호 앞에 0 붙이기
                System.out.println(addZero(digitCnt, answerInt));
            }
        }
    }
    //문자열로 변경 -> 하위 4자릿수 구하기
    public static String getDigit4(int num){
        String numString = Integer.toBinaryString(num);
        if (numString.length() > 3){
            return numString.substring(numString.length() -4);
        }else {
            if (numString.length() == 3){
                return "0" + numString;
            }else if (numString.length() == 2){
                return "00" + numString;
            }else {
                return "000" + numString;
            }
        }
    }
    //세 비밀번호 합치기
    public static String attachNums(String[] nums){
        return nums[0] + nums[1] + nums[2];
    }
    //비밀번호 자릿수구하기
    public static int getDigitCnt(int answer){
        int cnt = 0;
        if (answer == 0){
            return 1;
        }
        while(answer != 0){
            answer = answer / 10;
            cnt++;
        }
        return cnt;
    }
    //앞에 0넣어주기
    public static String addZero(int answersNum, int answer){
        StringBuilder st = new StringBuilder();
        st.append(answer);
        for (int i = 0; i < 4 - answersNum; i++){
            st.insert(0, "0");
        }
        return st.toString();
    }
}
