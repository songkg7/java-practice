package leetcode.reductionoperation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int reductionOperations(int[] nums) {
        // desc 로 정렬
        // nums 를 이진탐색을 통해 숫자가 바뀌는 인덱스를 찾아서 list 에 담아놓는다 (min=nums[0] 제외)
        // 2, 4
        // (nums.length - 4) + (nums.length - 2)
        // arrayValue, index
        Arrays.sort(nums);
        int cnt = 0;
        int max = nums[nums.length - 1];
        int min = nums[0];

        List<Integer> changes = new ArrayList<>();
        for (int i = min + 1; i <= max; i++) {
            int foundValue = findFirst(nums, nums.length - 1, i);

            if (foundValue >= 0) {
                changes.add(foundValue);
            }
        }

        for (Integer index : changes) {
            cnt += nums.length - index;
        }

        return cnt;
    }

    private int findFirst(int[] nums, int currentIndex, int key) {
        if (currentIndex < 0) {
            return -1;
        }
        int foundValue = Arrays.binarySearch(nums, 0, currentIndex + 1, key);
        if (foundValue == currentIndex) {
            return currentIndex;
        }
        return findFirst(nums, foundValue, key);
    }
}
