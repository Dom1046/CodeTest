package code.grammarTest;


import java.util.HashSet;
import java.util.Set;

//Set
public class GramTest2 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(25);

        set.stream().filter(i->i==25).forEach(System.out::println);
    }
}
