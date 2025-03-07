package code.test;

import java.util.HashSet;
import java.util.Set;

//폰켓몬
public class CodeTest43 {
    public int solution(int[] nums) {
        int cntMonster = 0;

        //폰켓몬 갯수 세기
        Set<Integer> chosen = new HashSet<>();
        for(int num : nums){
            chosen.add(num);
        }
        //갯수
        cntMonster = chosen.size();
        return cntMonster < nums.length/2 ? cntMonster : nums.length/2;
    }
}
