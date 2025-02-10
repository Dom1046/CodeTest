import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long stones = Long.parseLong(br.readLine().trim());
        String answer;

        if (stones % 2 == 0) answer = "CY";
        else answer = "SK";
        System.out.println(answer);
    }
}