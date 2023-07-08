package leetcode.medianoftwosortedarray;

public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;
        int[] result = new int[size];
        int idx1 = 0;
        int idx2 = 0;
        int target = 0;
        while (idx1 < nums1.length && idx2 < nums2.length) {
            if (nums1[idx1] < nums2[idx2]) {
                result[target++] = nums1[idx1++];
            } else {
                result[target++] = nums2[idx2++];
            }
        }
        while (idx1 < nums1.length) {
            result[target++] = nums1[idx1++];
        }
        while (idx2 < nums2.length) {
            result[target++] = nums2[idx2++];
        }
        if (size % 2 == 0) {
            int a = size / 2;
            int b = a - 1;
            return (result[a] + result[b]) / 2.0;
        }
        return result[size / 2];
    }

}
