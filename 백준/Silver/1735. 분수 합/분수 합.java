import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static String getAnswer(Integer a, Integer b, Integer c, Integer d) {
        int mom = b * d;
        int son = a * d + c * b;

        int A;
        int B;
        if (mom > son) {
            A = mom;
            B = son;
        } else {
            B = mom;
            A = son;
        }

        while (B != 0) {
            int r = A % B;
            A = B;
            B = r;
        }
        mom = mom/A;
        son = son/A;
        return son + " " + mom;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer a = Integer.parseInt(st.nextToken());
        Integer b = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        Integer c = Integer.parseInt(st2.nextToken());
        Integer d = Integer.parseInt(st2.nextToken());

        String answer = getAnswer(a, b, c, d);
        System.out.println(answer);
    }
}
