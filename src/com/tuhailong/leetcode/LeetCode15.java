package com.tuhailong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * 链接：https://leetcode-cn.com/problems/3sum
 *
 * @author tuhailong
 * @since 2019-10-30
 */
class LeetCode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ans;
        }
        Arrays.sort(nums);
        int len = nums.length;
        if (nums[0] > 0 || nums[len - 1] < 0) {
            return ans;
        }
        for (int i = 0; i < len - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int lid = i + 1;
            int rid = len - 1;
            while (lid < rid) {
                int sum = nums[i] + nums[lid] + nums[rid];
                if (sum > 0) {
                    while (lid < rid && nums[rid] == nums[--rid]);
                } else if (sum < 0) {
                    while (lid < rid && nums[lid] == nums[++lid]);
                } else {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[lid]);
                    tmp.add(nums[rid]);
                    ans.add(tmp);
                    while (lid < rid && nums[rid] == nums[--rid]);
                    while (lid < rid && nums[lid] == nums[++lid]);
                }
            }
        }
        return ans;
    }
}
