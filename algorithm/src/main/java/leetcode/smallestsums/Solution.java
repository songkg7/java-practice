package leetcode.smallestsums;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    // k 개만큼의 pair 를 합계가 작은 순서대로 반환
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // nums1 and nums2 로 Pair 조합 생성하여 PriorityQueue 에 넣고 k 개 만큼 꺼내기
        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(Pair::sum));
        for (int i : nums1) {
            for (int j : nums2) {
                queue.offer(new Pair(i, j));
            }
        }
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (queue.isEmpty()) {
                return results;
            }
            results.add(queue.poll().toList());
        }
        return results;
    }

    static class Pair {
        private final int first;
        private final int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int sum() {
            return first + second;
        }

        public List<Integer> toList() {
            return List.of(first, second);
        }

    }

}
