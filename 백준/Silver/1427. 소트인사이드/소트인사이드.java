import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//소트인사이드
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char[] charArray = input.toCharArray();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < charArray.length; i++) {
            String ag = charArray[i]+"";
            list.add(Integer.parseInt(ag));
        }
        Collections.sort(list);
        Collections.reverse(list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        System.out.println(sb);
    }
}
