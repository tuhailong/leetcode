package com.tuhailong.leetcode;

/**
 * 假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，
 * 你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
 * 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。
 * 每个房子粉刷成不同颜色的花费是以一个 n x 3 的矩阵来表示的。
 * 例如，costs[0][0]表示第0号房子粉刷成红色的成本花费；costs[1][2]表示第1号房子粉刷成绿色的花费，以此类推。
 * 请你计算出粉刷完所有房子最少的花费成本。
 * 注意：
 * 所有花费均为正整数。
 * 示例：
 * 输入: [[17,2,17],[16,16,5],[14,3,19]]
 * 输出: 10
 * 解释: 将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色。
 *      最少花费: 2 + 5 + 3 = 10。
 * 链接：https://leetcode-cn.com/problems/paint-house
 *
 * @author tuhailong
 * @since 2019-11-19
 */
class LeetCode256 {
    // 动态规划
    public int minCost(int[][] costs) {
        int min = 0;
        if (costs == null || costs.length == 0) {
            return min;
        }
        int preRedTotalCost = 0;
        int preBlueTotalCost = 0;
        int preGreenTotalCost = 0;
        for (int i = 0; i < costs.length; i++) {
            min = Integer.MAX_VALUE;
            int redTotalCost = Math.min(preBlueTotalCost, preGreenTotalCost) + costs[i][0];
            min = Math.min(min, redTotalCost);
            int blueTotalCost = Math.min(preRedTotalCost, preGreenTotalCost) + costs[i][1];
            min = Math.min(min, blueTotalCost);
            int greenTotalCost = Math.min(preRedTotalCost, preBlueTotalCost) + costs[i][2];
            min = Math.min(min, greenTotalCost);
            preRedTotalCost = redTotalCost;
            preBlueTotalCost = blueTotalCost;
            preGreenTotalCost = greenTotalCost;
        }
        return min;
    }
}
