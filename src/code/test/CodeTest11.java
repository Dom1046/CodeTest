package code.test;

//붕대감기
public class CodeTest11 {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int index = 0;
        int max = health;
        int bandageNumber = 0;
        for (int time = 0; time <= attacks[attacks.length - 1][0]; time++) {
            if (health <= 0) {
                break;
            }
            // 좀비의 공격!
            if (time == attacks[index][0]) {
                health -= attacks[index][1];
                index += 1;
                bandageNumber = 0;
                if (index > attacks.length) {
                    index = 0;
                }
                continue;
            }
            //힐
            health += bandage[1];
            bandageNumber += 1;

            //연속 붕대감기 성공
            if (bandageNumber == bandage[0]) {
                health += bandage[2];
                bandageNumber = 0;
            }
            //최대체력 이상 힐 불가X
            if (health > max) {
                health = max;
            }
        }

        return health <= 0 ? -1 : health;
    }

    public static void main(String[] args) {
        CodeTest11 test = new CodeTest11();
        int[] bandage = {5, 1, 5};
        int[][] attacks = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};
        int health = 30;
        int solution = test.solution(bandage, health, attacks);
        System.out.println("solution = " + solution);

    }
}
