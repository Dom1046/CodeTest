import java.util.*;
class Solution {
    public String solution(int[] food) {
        return foodForParticipantB(foodForParticipantA(food));
    }

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