package com.tuhailong.leetcode;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 *
 * @author tuhailong
 * @since 2019-10-31
 */
class LeetCode16 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int fst = nums[0];
        int sed = nums[1];
        int thd = nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int lid = i + 1;
            int rid = nums.length - 1;
            while (lid < rid) {
                int sum = nums[i] + nums[lid] + nums[rid];
                int diff = Math.abs(target - sum);
                if (diff < minDiff) {
                    minDiff = diff;
                    fst = nums[i];
                    sed = nums[lid];
                    thd = nums[rid];
                }
                if (sum == target) {
                    return fst + sed + thd;
                } else if (sum > target) {
                    while (lid < rid && nums[rid] == nums[--rid]);
                } else {
                    while (lid < rid && nums[lid] == nums[++lid]);
                }
            }
        }
        return fst + sed + thd;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode16().threeSumClosest(new int[]{6,-18,-20,-7,-15,9,18,10,1,-20,-17,-19,-3,-5,-19,10,6,-11,1,-17,-15,6,17,-18,-3,16,19,-20,-3,-17,-15,-3,12,1,-9,4,1,12,-2,14,4,-4,19,-20,6,0,-19,18,14,1,-15,-5,14,12,-4,0,-10,6,6,-6,20,-8,-6,5,0,3,10,7,-2,17,20,12,19,-13,-1,10,-1,14,0,7,-3,10,14,14,11,0,-4,-15,-8,3,2,-5,9,10,16,-4,-3,-9,-8,-14,10,6,2,-12,-7,-16,-6,10}, -52));
    }
}
