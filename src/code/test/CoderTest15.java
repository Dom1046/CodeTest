package code.test;

public class CoderTest15 {
    public boolean solution(int x) {
        int sum = 0;
        int dex = x;
        for (int i = 0; i < (dex / 10 == 0 && dex > 0 ? -1 : i + 2); i++) {
            sum += dex % 10;
            dex = dex / 10;
        }
        int result = sum + dex;
        return x % result == 0;
    }

    public static void main(String[] args) {
        CoderTest15 test = new CoderTest15();
        boolean solution = test.solution(10);
        System.out.println("result = " + solution);
    }
}
