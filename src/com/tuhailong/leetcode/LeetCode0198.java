package com.tuhailong.leetcode;

/**
 * 198. 打家劫舍
 * <p>
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * <p>
 * 链接：https://leetcode-cn.com/problems/house-robber
 *
 * @author tuhailong
 * @since 2020-05-18
 */
public class LeetCode0198 {
    public static void main(String[] args) {
        LeetCode0198 obj = new LeetCode0198();
        System.out.println(obj.rob(new int[]{2, 7, 9, 3, 1}));
    }

    /*
      动态规划：
        dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])
        dp[-1] = 0, 且dp[0] = 0
     */
    public int rob(int[] nums) {
        int prevMax = 0;
        int currMax = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmp = currMax;
            currMax = Math.max(prevMax + nums[i], currMax);
            prevMax = tmp;
        }
        return currMax;
    }
}
