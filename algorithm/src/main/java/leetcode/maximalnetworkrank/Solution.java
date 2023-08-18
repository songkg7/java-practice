package leetcode.maximalnetworkrank;

import java.util.*;

public class Solution {

    public int maximalNetworkRank(int n, int[][] roads) {
        // 최대 간선 개수 세기
        // 직접 연결인 경우에는 1로 셈
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] road : roads) {
            graph.computeIfAbsent(road[0], k -> new HashSet<>()).add(road[1]);
            graph.computeIfAbsent(road[1], k -> new HashSet<>()).add(road[0]);
        }

        int maxRank = 0;

        for (int node1 = 0; node1 < n; node1++) {
            for (int node2 = node1 + 1; node2 < n; node2++) {
                int currentRank = graph.getOrDefault(node1, Collections.emptySet()).size()
                        + graph.getOrDefault(node2, Collections.emptySet()).size();

                if (graph.getOrDefault(node1, Collections.emptySet()).contains(node2)) {
                    currentRank--;
                }
                maxRank = Math.max(maxRank, currentRank);
            }
        }

        return maxRank;
    }

}
