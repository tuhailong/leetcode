package com.tuhailong.leetcode;

/**
 * 213. 打家劫舍 II
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * 这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * 示例 1:
 * 输入: [2,3,2]
 * 输出: 3
 * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2:
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 链接：https://leetcode-cn.com/problems/house-robber-ii
 *
 * @author tuhailong
 * @since 2020-05-20
 */
public class LeetCode0213 {
    /**
     * 动态规划，存在两种策略：
     *  1. 不抢第一家, 抢劫所得最高金额为max1
     *  2. 不抢最后一家, 抢劫所得最高金额为max2
     * 综合以上两种情况，抢劫所得最高金额为Math.max(max1, max2)
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        // 不抢最后一家
        int[] nums1 = new int[nums.length - 1];
        // 不抢第一家
        int[] nums2 = new int[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1) {
                nums1[i] = nums[i];
            }
            if (i > 0) {
                nums2[i - 1] = nums[i];
            }
        }
        return Math.max(doRob(nums1), doRob(nums2));
    }

    // dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1])
    // 其中，dp[-1] = dp[0] = 0
    private int doRob(int[] nums) {
        int prevSum = 0;
        int currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmp = currSum;
            currSum = Math.max(currSum, prevSum + nums[i]);
            prevSum = tmp;
        }
        return currSum;
    }
}
