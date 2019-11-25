package com.tuhailong.leetcode.sort;

import java.util.Arrays;

/**
 * 给你一个无序的数组 nums, 将该数字 原地 重排后使得 nums[0] <= nums[1] >= nums[2] <= nums[3]...。
 * 示例:
 * 输入: nums = [3,5,2,1,6,4]
 * 输出: 一个可能的解答是 [3,5,1,6,2,4]
 * 链接：https://leetcode-cn.com/problems/wiggle-sort
 */
public class LeetCode280 {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        if (nums.length < 3) {
            return;
        }
        int idx = 1;
        while (idx < nums.length) {
            if (idx + 1 >= nums.length) {
                break;
            }
            nums[idx] ^= nums[idx + 1];
            nums[idx + 1] ^= nums[idx];
            nums[idx] ^= nums[idx + 1];
            idx += 2;
        }
    }

    public static void main(String[] args) {
        LeetCode280 ni = new LeetCode280();
        int[] nums = {3, 5, 2, 1, 6, 4};
        ni.wiggleSort(nums);
    }
}
