import java.util.*;

//카드1
public class Main {

    public static void getSeqWithLastNum(int N) {
        Queue<Integer> deck = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        if (N == 1) System.out.println("1");
        else {
            for (int i = 1; i < N + 1; i++) {
                deck.add(i);
            }

            while (deck.size() != 1) {
                sb.append(deck.poll()).append(" ");
                deck.add(deck.poll());
            }
            System.out.println(sb.append(deck.poll()));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        getSeqWithLastNum(N);
    }
}
