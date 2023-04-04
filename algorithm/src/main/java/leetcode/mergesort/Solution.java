package leetcode.mergesort;

class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 3개의 포인터를 사용한다.
        int i = m - 1;
        int j = n - 1;
        int k = nums1.length - 1;

        // nums2 의 배열 사이즈가 nums1 보다 작으므로 nums2 를 순회한다.
        while (j >= 0) {
            // i 에 비교할 숫자가 남아있는지, 비교 대상 숫자가 nums2 보다 큰지 검사한다.
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                // 각 포인터를 감소시킨다.
                k--;
                i--;
            } else {
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }
    }

}
