package code.test;
//동영상 재생기
public class CodeTest20 {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String[] splitVideo_len = video_len.split(":");
        String[] splitPos = pos.split(":");
        String[] splitOp_start = op_start.split(":");
        String[] splitOp_end = op_end.split(":");

        // 비디오 길이
        int videoLenInSeconds = makeInteger(splitVideo_len[0]) * 60 + makeInteger(splitVideo_len[1]);

        // 오프닝 시작과 종료 시간
        int openingStart = makeInteger(splitOp_start[0]) * 60 + makeInteger(splitOp_start[1]);
        int openingEnd = makeInteger(splitOp_end[0]) * 60 + makeInteger(splitOp_end[1]);

        // 현재 위치
        int posTimeInSeconds = makeInteger(splitPos[0]) * 60 + makeInteger(splitPos[1]);

        for (String command : commands) {
            if (openingStart < posTimeInSeconds && posTimeInSeconds < openingEnd) {
                posTimeInSeconds = makeInteger(splitOp_end[0]) * 60 + makeInteger(splitOp_end[1]);
            }

            if (command.equals("prev")) {
                posTimeInSeconds -= 10;
                if (posTimeInSeconds < 0) {
                    posTimeInSeconds = 0;
                }
            } else if (command.equals("next")) {
                posTimeInSeconds += 10;
                if (posTimeInSeconds >= videoLenInSeconds) {
                    posTimeInSeconds = videoLenInSeconds;
                }
            }

            if (openingStart < posTimeInSeconds && posTimeInSeconds < openingEnd) {
                posTimeInSeconds = makeInteger(splitOp_end[0]) * 60 + makeInteger(splitOp_end[1]);
            }
        }

        // 결과를 "MM:SS" 형식으로 변환
        int minutes = posTimeInSeconds / 60;
        int seconds = posTimeInSeconds % 60;
        String result = String.format("%02d:%02d", minutes, seconds);
        return result;
    }

    public int makeInteger(String stringTime) {
        return Integer.parseInt(stringTime);
    }

}
