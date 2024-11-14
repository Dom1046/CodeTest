package code.test;

import java.util.LinkedList;
import java.util.Queue;

public class CoderTest16 {

    public long solution(int[] queue1, int[] queue2) {
        Queue<Long> queueA = new LinkedList<>();
        Queue<Long> queueB = new LinkedList<>();
        long cnt = 0;

        long sumA = 0;
        long sumB = 0;

        for (int j : queue1) {
            long value = (long) j;
            queueA.offer(value);
            sumA += value;
        }

        for (int j : queue2) {
            long value = (long) j;
            queueB.offer(value);
            sumB += value;
        }

        int maxMoves = (queue1.length + queue2.length) * 2;

        while (cnt <= maxMoves) {
            if (sumA == sumB) {
                return cnt;
            }

            if (sumA > sumB) {
                long pollNum = queueA.poll();
                queueB.offer(pollNum);
                sumA -= pollNum;
                sumB += pollNum;
            } else {
                long pollNum = queueB.poll();
                queueA.offer(pollNum);
                sumB -= pollNum;
                sumA += pollNum;
            }
            cnt++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] queue1 = {1, 5};
        int[] queue2 = {1, 1};
        CoderTest16 test = new CoderTest16();
        long solution = test.solution(queue1, queue2);
        System.out.println("solution = " + solution);
    }
}
//    public long solution(int[] queue1, int[] queue2) {
//        Queue<Long> queueA = new LinkedList<>();
//        Queue<Long> queueB = new LinkedList<>();
//        long cnt = 0;
//
//        for (long j : queue1) {
//            queueA.offer(j);
//        }
//        for (long j : queue2) {
//            queueB.offer(j);
//        }
//        for (long i = 0; i <= queueA.size() * queueB.size(); i++) {
//            long ax = sumAllNum(queueA);
//            long bx = sumAllNum(queueB);
//            if (ax > bx) {
//                Long pollNum = queueA.poll();
//                queueB.offer(pollNum);
//                cnt++;
//            } else if (ax < bx) {
//                Long pollNum = queueB.poll();
//                queueA.offer(pollNum);
//                cnt++;
//            }
//
//            if (queueA.size()*queueB.size() == 0) return cnt = -1;
//        }
//        return cnt;
//    }
//
//    public long sumAllNum(Queue<Long> queue) {
//        long sum = 0;
//        for (Long i : queue) {
//            sum += i;
//        }
//        return sum;
//    }