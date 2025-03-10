import java.util.Scanner;
import java.util.Stack;

//괄호
public class Main {

    public static void getYesOrNo(String[] bracketStrings) {

        String result = "YES";
        for (String bracketString : bracketStrings) {
            Stack<Character> stack = new Stack<>();

            char[] brackets = bracketString.toCharArray();
            for (char bracket : brackets) {
                if (bracket == ('(')) {
                    stack.push(bracket);
                } else {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }else {
                        result = "NO";
                        break;
                    }
                }
            }
            if (!stack.isEmpty()) result = "NO";
            System.out.println(result);
            stack.clear();
            result = "YES";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        int n = Integer.parseInt(in);
        String[] bracketStrings = new String[n];

        for (int i = 0; i < n; i++) {
            bracketStrings[i] = sc.nextLine();
        }

        getYesOrNo(bracketStrings);
    }
}
