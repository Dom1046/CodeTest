package code.test;

import java.util.ArrayList;
import java.util.List;

//Shuffle the Array
public class CodeTest38 {
    public int[] shuffle(int[] nums, int n) {
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        List<Integer> listC = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i < n) {
                listA.add(nums[i]);
            } else {
                listB.add(nums[i]);
            }
        }
        for (int i = 0; i < listA.size(); i++) {
            listC.add(listA.get(i));
            listC.add(listB.get(i));
        }
        return listC.stream().mapToInt(i -> i).toArray();
    }
}
