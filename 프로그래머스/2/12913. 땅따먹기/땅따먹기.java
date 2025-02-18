class Solution {
    int solution(int[][] land) {
        int n = land.length; // 행 개수
        
        // DP 방식으로 land 배열을 직접 갱신
        for (int i = 1; i < n; i++) {
            land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
            land[i][2] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][3]));
            land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][2]));
        }

        // 마지막 행에서 최댓값 반환
        return Math.max(land[n-1][0], Math.max(land[n-1][1], Math.max(land[n-1][2], land[n-1][3])));
    }
}