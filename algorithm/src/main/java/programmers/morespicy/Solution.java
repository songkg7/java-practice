package programmers.morespicy;

import java.util.PriorityQueue;

public class Solution {
    // 섞은 음식의 스코비 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> result = new PriorityQueue<>();
        for (int i : scoville) {
            result.add(i);
        }

        int mixCount = 0;

        while (result.peek() < K) {
            if (result.size() == 1) {
                return -1;
            }
            int f1 = result.poll();
            int f2 = result.poll();
            mixCount++;
            int mixed = f1 + (f2 * 2);
            if (mixed > K) {
                result.add(mixed);
            }
            result.add(mixed);
        }

        return mixCount;
    }
}
