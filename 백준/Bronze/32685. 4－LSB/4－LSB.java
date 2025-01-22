import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 한 줄에 공백으로 구분된 3개의 정수 입력
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();

        // 각 정수의 하위 4자리(2진수) 구하기
        String bin1 = getDigit4(num1);
        String bin2 = getDigit4(num2);
        String bin3 = getDigit4(num3);

        // 세 개의 이진 문자열을 순서대로 이어 붙이기
        String combined = bin1 + bin2 + bin3;

        // 이진수 -> 십진수로 변환
        int answerInt = Integer.parseInt(combined, 2);

        // 네 자리로 맞추기 (앞에 0 추가)
        String answer = addZero(answerInt);

        // 결과 출력
        System.out.println(answer);
    }

    /**
     * 정수 num의 하위 4비트를 2진수 문자열(4자리)로 반환
     */
    public static String getDigit4(int num) {
        String binary = Integer.toBinaryString(num);
        // 길이가 4 미만이면 0으로 앞을 채우고, 4 이상이면 뒤 4자리만 추출
        if (binary.length() < 4) {
            binary = String.format("%4s", binary).replace(' ', '0');
        } else {
            binary = binary.substring(binary.length() - 4);
        }
        return binary;
    }

    /**
     * 십진수 숫자를 받아서 항상 4자리로 맞춰주는 함수 (앞에 0 채움)
     */
    public static String addZero(int answer) {
        // 예: answer=103 → "0103", answer=5 → "0005"
        return String.format("%04d", answer);
    }
}
