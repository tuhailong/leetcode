package com.tuhailong.leetcode;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * 链接：https://leetcode-cn.com/problems/two-sum
 *
 * @author tuhailong
 * @since 2019-10-29
 */
class LeetCode1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int idx = 0; idx < nums.length; idx++) {
            int diff = target - nums[idx];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), idx};
            }
            map.put(nums[idx], idx);
        }
        return null;
    }
}
