import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();

        //개인정보 (번호, 종류, 일수)
        List<List<Integer>> privateInfo = getPrivacyDays(privacies, getTodayDays(today));

        //유효기간 (종류, 일수)
        Map<Integer, Integer> expirationInfo = getExpiration(terms);

        //만료된 정보 찾기
        for (int i = 0; i < privateInfo.size(); i++) {
            int number = privateInfo.get(i).get(0);
            int type = privateInfo.get(i).get(1);
            int days = privateInfo.get(i).get(2);

            if (days >= expirationInfo.get(type)){
                answer.add(number);
            };
        }

        //int[]에 담기
        int[] answerArray = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            answerArray[i] = answer.get(i);
        }
        return answerArray;
    }

    //개인정보 리스트에 정리 + ( 오늘일수 - 유효기간 일수 )
    public List<List<Integer>> getPrivacyDays(String[] privacies, int todayDays) {
        List<List<Integer>> privacyDays = new ArrayList<>();
        int index = 1;

        //1.날짜,종류 분리하기
        for (String privacy : privacies) {
            String[] dateNType = privacy.split(" ");
            String[] date = dateNType[0].split("\\.");
            //2. 날짜 일수로 변경하기
            int year = Integer.parseInt(date[0]) * 12 * 28;
            int month = Integer.parseInt(date[1]) * 28;
            int days = Integer.parseInt(date[2]);
            //3. 번호, 타입, 일수 리스트에 넣기
            privacyDays.add(List.of(index, (int) dateNType[1].charAt(0), todayDays - (year + month + days)));
            index++;
        }
        return privacyDays;
    }

    //오늘 날짜 -> 일로 변경
    public int getTodayDays(String today) {
        String[] todayDays = today.split("\\.");

        int year = Integer.parseInt(todayDays[0]) * 12 * 28;
        int month = Integer.parseInt(todayDays[1]) * 28;
        int days = Integer.parseInt(todayDays[2]);

        return year + month + days;
    }

    //유효기간 정보 ( 개월 -> 일 / 유효기간 타입 -> key, value)로 정보 저장
    public Map<Integer, Integer> getExpiration(String[] terms) {

        Map<Integer, Integer> expireDaysNType = new HashMap<>();

        for (String term : terms) {
            String[] splitTerm = term.split(" ");
            char type = splitTerm[0].charAt(0);
            int days = Integer.parseInt(splitTerm[1]) * 28;
            expireDaysNType.put((int)type, days);
        }

        return expireDaysNType;
    }
}