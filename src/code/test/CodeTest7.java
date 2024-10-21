package code.test;

import java.util.ArrayList;
import java.util.List;

public class CodeTest7 {
    static int cntBurger = 0;

    public int solution(int[] ingredient) {
        List<Integer> listIng = new ArrayList<>();
        for (int ing : ingredient) {
            listIng.add(ing);
        }
        while (true) {
            int index = ingChecker(listIng);
            if (index == -1) break;
            listIng = packBurger(listIng, index);
        }
        return cntBurger;
    }

    public int ingChecker(List<Integer> listIng) {
        for (int i = 0; i <= listIng.size() - 4; i++) {
            if (listIng.get(i) == 1 && listIng.get(i + 1) == 2 && listIng.get(i + 2) == 3 && listIng.get(i + 3) == 1) {
                return i + 3;
            }
        }
        return -1;
    }

    public List<Integer> packBurger(List<Integer> listIng, int index) {
        listIng.remove(index);
        listIng.remove(index-1);
        listIng.remove(index-2);
        listIng.remove(index-3);
        cntBurger++;
        return listIng;
    }

    public static void main(String[] args) {
        CodeTest7 test = new CodeTest7();
        int[] ingredient = new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2};
        System.out.println(test.solution(ingredient));
    }
}
