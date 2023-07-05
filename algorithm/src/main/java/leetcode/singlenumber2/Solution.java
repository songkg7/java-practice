package leetcode.singlenumber2;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.get(num) == null) {
                map.put(num, 1);
            } else if (map.get(num) == 2) {
                map.remove(num);
            } else {
                map.replace(num, map.get(num) + 1);
            }
        }
        return map.keySet().stream().findFirst().get();
    }

}
