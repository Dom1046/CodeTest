package code.test;

public class CodeTest13 {
    static int diamond = 0;
    static int iron = 0;
    static int stone = 0;
    static int fatigue = 0;

    public int solution(int[] picks, String[] minerals) {
        int length = (minerals.length % 5 == 0 ? minerals.length / 5 : minerals.length / 5 + 1);
        diamond = picks[0];
        iron = picks[1];
        stone = picks[2];

        String[] strings = whichMineral(minerals);
        for (int i = 0; i < length; i++) {
            if (strings[i].equals("diamond") && diamond > 0) {
                mining("diamond", minerals, i);
                diamond--;
            } else if ((strings[i].equals("iron") || strings[i].equals("diamond")) && iron > 0) {
                mining("iron", minerals, i);
                iron--;
            } else if (stone > 0) {
                mining("stone", minerals, i);
                stone--;
            }
        }
        return fatigue;
    }

    // 최적 광물 찾기
    public String[] whichMineral(String[] minerals) {
        int length = (minerals.length % 5 == 0 ? minerals.length / 5 : minerals.length / 5 + 1);
        String[] mostMinerals = new String[length];

        for (int i = 0; i < length; i++) {
            int diamondCount = 0;
            int ironCount = 0;
            int stoneCount = 0;
            int index = i * 5;
            for (int j = index; j < Math.min(5 * (i + 1), minerals.length); j++) {
                if (minerals[j].equals("diamond")) {
                    diamondCount++;
                } else if (minerals[j].equals("iron")) {
                    ironCount++;
                } else {
                    stoneCount++;
                }
            }
            // 최대 광물 종류를 구함
            if (diamondCount >= ironCount && diamondCount >= stoneCount) {
                mostMinerals[i] = "diamond";
            } else if (ironCount >= stoneCount) {
                mostMinerals[i] = "iron";
            } else {
                mostMinerals[i] = "stone";
            }
        }
        return mostMinerals;
    }

    // 피로도 계산
    public void mining(String equipment, String[] minerals, int index) {
        for (int i = index * 5; i < Math.min((index + 1) * 5, minerals.length); i++) {
            if (equipment.equals("diamond")) {
                fatigue += 1;
            } else if (equipment.equals("iron")) {
                if (minerals[i].equals("diamond")) {
                    fatigue += 5;
                } else {
                    fatigue += 1;
                }
            } else if (equipment.equals("stone")) {
                if (minerals[i].equals("diamond")) {
                    fatigue += 25;
                } else if (minerals[i].equals("iron")) {
                    fatigue += 5;
                } else {
                    fatigue += 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] picks = {0, 1, 1};
        String[] minerals = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};
        CodeTest13 test = new CodeTest13();
        int solution = test.solution(picks, minerals);
        System.out.println("solution = " + solution);
    }
}
