import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            //이진수 변환 -> 2개 지도 겹치기 (1줄씩) -> 1줄씩 해독하기
            answer[i] = decodeMap(OverlayMaps(toBinary(arr1[i], n), toBinary(arr2[i], n)));
        }
        return answer;
    }

    //십진수 -> 이진수로 변환
    public List<Integer> toBinary(int arr, int length) {
        //이진수 리스트
        List<Integer> binary = new ArrayList<>(Collections.nCopies(length, 0));

        int index = length - 1;

        while (arr > 0) {
            binary.set(index, arr % 2);
            arr /= 2;
            index--;
        }
        return binary;
    }

    //2개의 지도 겹치기
    public List<Integer> OverlayMaps(List<Integer> mapA, List<Integer> mapB) {
        List<Integer> secretMap = new ArrayList<>();

        for (int i = 0; i < mapA.size(); i++) {
            secretMap.add(mapA.get(i) + mapB.get(i));
        }
        return secretMap;
    }

    //지도 해독하기
    public String decodeMap(List<Integer> secretMap){
        StringBuilder decodedMap = new StringBuilder();
        for (Integer secret : secretMap) {
            if (secret > 0) {
                decodedMap.append("#");
            } else decodedMap.append(" ");
        }
        return decodedMap.toString();
    }
}
