import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line1 = sc.nextLine().split(" ");
        String[] line2 = sc.nextLine().split(" ");

        int N = Integer.parseInt(line1[0]);
        int M = Integer.parseInt(line1[1]);

        //중복되는 편의점 브랜드 확인 + 인원 배치
        Map<String, Integer> storeMap = new HashMap<>();
        for (String store : line2) {
            storeMap = checkDuplicate(store, storeMap);
        }
        //배치된 인원 중 최소투입 인원 찾기
        System.out.println(getMinPs(storeMap));
    }
    //중복되는 편의점 브랜드 확인 + 인원 배치
    public static Map<String, Integer> checkDuplicate(String store, Map<String, Integer> storeMap) {
        //존재하면 인원 +1, 없다면 1추가해서 넣기
        if (storeMap.get(store) != null){
            int person = storeMap.get(store) + 1;
            storeMap.put(store, person);
        }else {
            storeMap.put(store, 1);
        }
        return storeMap;
    }
    //배치된 인원 중 최소투입 인원 찾기
    public static int getMinPs(Map<String, Integer> storeMap) {
        int minPs = 0;
        //인원이 더 많은 것을 발견하면, 변경
        for (Integer people : storeMap.values()){
            if (people > minPs){
                minPs = people;
            }
        }
        return minPs;
    }
}