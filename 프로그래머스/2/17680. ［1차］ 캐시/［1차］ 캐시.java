
import java.util.*;

class Solution {
public int solution(int cacheSize, String[] cities) {

        int answer = 0;
        //큐에 넣기 -> 순차적으로 빠짐
        Queue<String> queue = new LinkedList<>();

        for (String city : cities) {
            //대문자, 공백 제거
            city = city.toUpperCase().trim();

            //cacheSize가 0일 경우 모든 city 메모리 5로 계산
            if (cacheSize <= 0) {
                answer = cities.length * 5;
                //빠져나온다
                break;
            }

            // 큐에 city가 존재할 경우 city를 제거하고 메모리 1을 추가
            if (queue.contains(city)) {
                //해당 city 제거
                queue.remove(city);
                answer += 1;
            } else {
                // 캐시에 존재하지 않는 city라면 메모리 5계산
                answer += 5;
            }
            //도시 큐에 입력
            queue.offer(city);
            // 가장 오래된 캐시 삭제
            if (queue.size() > cacheSize) queue.poll();
        }
        return answer;
    }
}