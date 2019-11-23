package com.tuhailong.leetcode;

/**
 * 给定两个大小为 len1 和 len2 的有序数组 nums1 和 nums2
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 * <p>
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 *
 * @author tuhailong
 * @since 2019-10-29
 */
public class LeetCode4 {
    private LeetCode4() {
    }

    /**
     * 找出这两个有序数组的中位数
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 中位数
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int idx = 0;
        int idx1 = 0;
        int idx2 = 0;
        while (idx1 < nums1.length && idx2 < nums2.length) {
            nums[idx++] = (nums1[idx1] <= nums2[idx2]) ? nums1[idx1++] : nums2[idx2++];
        }
        if (idx1 == nums1.length) {
            while (idx2 < nums2.length) {
                nums[idx++] = nums2[idx2++];
            }
        } else if (idx2 == nums2.length) {
            while (idx1 < nums1.length) {
                nums[idx++] = nums1[idx1++];
            }
        }
        if (nums.length % 2 == 0) {
            return (nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2.0;
        } else {
            return nums[nums.length / 2] / 1.0;
        }
    }
}
