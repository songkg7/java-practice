package leetcode.permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTracking(result, nums, new ArrayList<>());
        return result;
    }

    private void backTracking(List<List<Integer>> result, int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int num: nums) {
            if (!list.contains(num)) {
                list.add(num);
                backTracking(result, nums, list);
                list.remove(list.size() - 1);
            }
        }
    }

}
