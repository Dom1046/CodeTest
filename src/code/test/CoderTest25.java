package code.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//푸드파이터
public class CoderTest25 {
    public String solution(int[] food) {
        return foodForParticipantB(foodForParticipantA(food));
    }

    //참가자A를 위한 음식
    public List<Integer> foodForParticipantA(int[] foods) {
        List<Integer> foodA = new ArrayList<>();
        int foodOrder = 1;

        for (int i = 1; i < foods.length; i++) {
            if (2 <= foods[i]) {
                for (int j = 0; j < (int) Math.floor((double) foods[i] / 2); j++) {
                    foodA.add(foodOrder);
                }
            }
            foodOrder++;
        }
        return foodA;
    }

    //참가자B를 위한 음식
    public String foodForParticipantB(List<Integer> foodA) {
        StringBuilder totalFood = new StringBuilder();

        //왼쪽 음식 세팅
        for (Integer eachFood : foodA) {
            totalFood.append(eachFood);
        }
        //중간에 물 넣기
        totalFood.append("0");

        //오른쪽 음식 세팅
        Collections.reverse(foodA);
        for (Integer eachFood : foodA) {
            totalFood.append(eachFood);
        }
        return totalFood.toString();
    }

}
