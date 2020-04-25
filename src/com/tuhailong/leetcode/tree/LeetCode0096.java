package com.tuhailong.leetcode.tree;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * 示例:
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees
 *
 * @author tuhailong
 * @since 2019-11-27
 */
class LeetCode0096 {
    /**
     * 解题思路：动态规划
     * G(n)等于对G(i-1)*G(n-i)的积从1到n求和
     */
    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    /**
     * 算法思路：数学演绎法
     *   G(0)=1, G(n+1)=(2(2n+1)/(n+2))*C(n)
     */
    public int numTreesOptd(int n) {
        long g = 1;
        for (int i = 0; i < n; i++) {
            g = g * 2 * (2 * i + 1) / (i + 2);
        }
        return (int)g;
    }
}
