import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//카드2
public class Main {

    public static void getSeqWithLastNum(int N) {
        Queue<Integer> deck = new LinkedList<>();
        if (N == 1) System.out.println("1");
        else {
            for (int i = 1; i < N + 1; i++) {
                deck.add(i);
            }

            while (deck.size() != 1) {
                deck.poll();
                deck.add(deck.poll());
            }
            System.out.println(deck.poll());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        getSeqWithLastNum(N);
        sc.close();
    }
}
