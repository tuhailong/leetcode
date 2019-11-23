package com.tuhailong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d,
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 注意：
 * 答案中不可以包含重复的四元组。
 * 示例：
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * 链接：https://leetcode-cn.com/problems/4sum
 *
 * @author tuhailong
 * @since 2019-10-31
 */
class LeetCode18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return ans;
        }
        List<Integer> tmp = null;
        if (nums.length == 4 && (nums[0] + nums[1] + nums[2] + nums[3] == target)) {
            tmp = new ArrayList<>();
            tmp.add(nums[0]);
            tmp.add(nums[1]);
            tmp.add(nums[2]);
            tmp.add(nums[3]);
            ans.add(tmp);
            return ans;
        }
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len - 3; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (nums[i] + nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < len - 2; j++) {
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                    continue;
                }
                if (j - i > 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int lid = j + 1;
                int rid = nums.length - 1;
                while (lid < rid) {
                    int sum = nums[i] + nums[j] + nums[lid] + nums[rid];
                    if (sum > target) {
                        while (lid < rid && nums[rid] == nums[--rid]);
                    } else if (sum < target) {
                        while (lid < rid && nums[lid] == nums[++lid]);
                    } else {
                        tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[lid]);
                        tmp.add(nums[rid]);
                        ans.add(tmp);
                        while (lid < rid && nums[rid] == nums[--rid]);
                        while (lid < rid && nums[lid] == nums[++lid]);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode18().fourSum(new int[]{1,-2,-5,-4,-3,3,3,5}, -11));
    }
}
