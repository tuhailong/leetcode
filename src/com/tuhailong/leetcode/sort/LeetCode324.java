package com.tuhailong.leetcode;

import java.util.Arrays;

/**
 * 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * 示例 1:
 * 输入: nums = [1, 5, 1, 1, 6, 4]
 * 输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]
 * 输入: nums = [1, 3, 2, 2, 3, 1]
 * 输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2]
 * 你可以假设所有输入都会得到有效的结果。
 * 你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
 * 链接：https://leetcode-cn.com/problems/wiggle-sort-ii
 *
 * @author tuhailong
 * @since 2019-11-25
 */
class LeetCode324 {
    public void wiggleSort(int[] nums) {
        int[] tmps = Arrays.copyOf(nums, nums.length);
        Arrays.sort(tmps);
        int len = tmps.length;
        int mid = len / 2;
        if (len % 2 != 0) {
            mid += 1;
        }
        int eid = len - 1;
        for (int i = 0; i < len; i++) {
            nums[i] = i % 2 == 0 ? tmps[--mid] : tmps[eid--];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 1, 1, 6, 4};
        //int[] nums = {4, 5, 5, 6};
        LeetCode324 ni = new LeetCode324();
        ni.wiggleSort(nums);
    }
}
