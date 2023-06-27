package leetcode.smallestsums;

import java.util.*;

public class Solution {

    // k 개만큼의 pair 를 합계가 작은 순서대로 반환
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 배열이 오름차순으로 정렬되어 있다는걸 이용해서 가장 작은 순서쌍 k 개를 바로 생성하기
        int m = nums1.length;
        int n = nums2.length;

        List<List<Integer>> answer = new ArrayList<>();
        Set<Pair> visited = new HashSet<>();

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{nums1[0] + nums2[0], 0, 0});
        visited.add(new Pair(0, 0));

        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int i = top[1];
            int j = top[2];

            answer.add(List.of(nums1[i], nums2[j]));

            if (i + 1 < m && !visited.contains(new Pair(i + 1, j))) {
                minHeap.offer(new int[]{nums1[i + 1] + nums2[j], i + 1, j});
                visited.add(new Pair(i + 1, j));
            }

            if (j + 1 < n && !visited.contains(new Pair(i, j + 1))) {
                minHeap.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
                visited.add(new Pair(i, j + 1));
            }
        }

        return answer;
    }

    static class Pair {
        private final int first;
        private final int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return first == pair.first && second == pair.second;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }

}
