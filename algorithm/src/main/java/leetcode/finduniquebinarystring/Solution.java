package leetcode.finduniquebinarystring;

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        // nums 를 10진수로 바꾼 후, 1부터 찾다가 없는 첫번째 숫자를 반환
        int[] array = new int[(int) Math.pow(2, nums.length)];
        for (String s : nums) {
            int i = Integer.parseInt(s, 2);
            array[i] = 1;
        }
        String ans = "";
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                ans = Integer.toBinaryString(i);
                break;
            }
        }
        int zeroCount = nums.length - ans.length();
        String zero = "0".repeat(zeroCount);
        return zero + ans;
    }
}
