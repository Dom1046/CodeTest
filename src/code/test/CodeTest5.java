package code.test;

// 기사단의 무기
public class CodeTest5 {
    public int solution(int number, int limit, int power) {

        int count = 0;
        int[] knightPowers = new int[number];
        for (int i = 0; i < number; i++) {
            knightPowers[i] = findRealPower(findKnightPower(number - i, count), power, limit);
        }
        return findTotalSteelWeight(knightPowers);
    }

    // 1. 약수갯수 구하기
    public int findKnightPower(int knightNum, int count) {
        for (int i = 1; i * i <= knightNum; i++) {
            if (i * i == knightNum) count++;
            else if (knightNum % i == 0) count += 2;
        }
        return count;
    }

    // 2. 기사들의 공격력 찾기
    public int findRealPower(int knightPower, int power, int limit) {
        if (knightPower > limit) return power;
        else return knightPower;
    }

    // 3. 철의 무게 계산
    public int findTotalSteelWeight(int[] knightPowers) {
        int totalPower = 0;
        for (int knightPower : knightPowers) {
            totalPower += knightPower;
        }
        return totalPower;
    }
}
