package com.tuhailong.leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给定一个长度为n的整数数组和一个目标值target,
 * 寻找能够使条件nums[i] + nums[j] + nums[k] < target 成立的三元组  i, j, k 个数（0 <= i < j < k < n）。
 * 示例：
 * 输入: nums = [-2,0,1,3], target = 2
 * 输出: 2
 * 解释: 因为一共有两个三元组满足累加和小于 2:
 *      [-2,0,1]
 *      [-2,0,3]
 * 进阶：是否能在O(n^2)的时间复杂度内解决？
 * 链接：https://leetcode-cn.com/problems/3sum-smaller
 *
 * @author tuhailong
 * @since 2019-12-02
 */
class LeetCode259 {
    public int threeSumSmallerOpted(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int right = -1;
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[0] + nums[1] + nums[i] < target) {
                right = i;
                break;
            }
        }
        if (right == -1) {
            return 0;
        }
        int cnt = 0;
        for (int i = 0; i < right - 1; i++) {
            int lid = i + 1;
            int rid = right;
            while (lid < rid) {
                if (nums[i] + nums[lid] + nums[rid] < target) {
                    cnt += (rid - lid);
                    ++lid;
                } else {
                    --rid;
                }
            }
        }
        return cnt;
    }

    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int right = -1;
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[0] + nums[1] + nums[i] < target) {
                right = i;
                break;
            }
        }
        if (right == -1) {
            return 0;
        }
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = right; i >= 2 ; i--) {
            for (int j = i - 1; j >= 1; j--) {
                for (int k = j - 1; k >= 0; k--) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum >= target) {
                        continue;
                    }
                    list.add(new int[] {nums[k], nums[j], nums[i]});
                }
            }
        }
        return list.size();
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 0, -2};
        LeetCode259 ni = new LeetCode259();
        System.out.println(ni.threeSumSmaller(nums, 4));
    }
}
