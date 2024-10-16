package code.test;
//지폐 접기
public class CodeTest {
    static int count = 0;

    public int solution(int[] wallet, int[] bill) {
        while (isBiggerBill(wallet, bill)) {
            int[] bills = foldBill(wallet, bill);
            if (isSuitable(wallet, bills)) {
                break;
            }
            int[] turnedBill = turnBill(bills);
            if (isSuitable(wallet, turnedBill)) {
                break;
            }
            turnBill(bills);
        }
        return count;
    }

    public int[] foldBill(int[] wallet, int[] bill) {

        if (wallet[0] < bill[0]) {
            count++;
            bill[0] = bill[0] / 2;
        } else if (wallet[1] < bill[1]) {
            count++;
            bill[1] = bill[1] / 2;
        }
        return bill;
    }

    public boolean isBiggerBill(int[] wallet, int[] bill) {
        return wallet[0] < bill[0] || wallet[1] < bill[1];
    }

    public int[] turnBill(int[] bill) {
        int temp = bill[0];
        bill[0] = bill[1];
        bill[1] = temp;
        return bill;
    }

    public boolean isSuitable(int[] wallet, int[] bill) {
        return wallet[0] >= bill[0] && wallet[1] >= bill[1];
    }

    public static void main(String[] args) {
        int[] wallet = new int[]{15, 30};
        int[] bill = new int[]{26, 17};
        CodeTest test = new CodeTest();
        test.solution(wallet, bill);
        System.out.println("result = " + test.solution(wallet, bill));
    }
}
