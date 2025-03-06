import java.util.Scanner;

//막대기
public class Main {

    public static void getVisibleBars(int[] bars) {
        int longest = getLongest(bars);
        answer(visibleBars(bars, longest));
    }

    public static int getLongest(int[] bars) {
        return bars[bars.length - 1];
    }

    public static int visibleBars(int[] bars, int longest) {
        int visibleBars = 1;
        for (int i = bars.length - 1; i > 0; i--) {
            if (bars[i - 1] > longest) {
                longest = bars[i - 1];
                visibleBars++;
            }
        }
        return visibleBars;
    }

    public static void answer(int answer) {
        System.out.println(answer);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] bars = new int[n];

        for (int i = 0; i < n; i++) {
            bars[i] = sc.nextInt();
        }
        getVisibleBars(bars);
    }
}
