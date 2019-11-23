package com.tuhailong.leetcode;

/**
 * 有 k 种颜色的涂料和一个包含 n 个栅栏柱的栅栏，每个栅栏柱可以用其中一种颜色进行上色。
 * 你需要给所有栅栏柱上色，并且保证其中相邻的栅栏柱 最多连续两个 颜色相同。
 * 然后，返回所有有效涂色的方案数。
 * 注意:
 * n 和 k 均为非负的整数。
 * 示例:
 * 输入: n = 3，k = 2
 * 输出: 6
 * 解析: 用 c1 表示颜色 1，c2 表示颜色 2，所有可能的涂色方案有:
 *             柱 1    柱 2   柱 3
 *  -----      -----  -----  -----
 *    1         c1     c1     c2
 *    2         c1     c2     c1
 *    3         c1     c2     c2
 *    4         c2     c1     c1 
 *    5         c2     c1     c2
 *    6         c2     c2     c1
 * 链接：https://leetcode-cn.com/problems/paint-fence
 */

public class LeetCode276 {
    /**
     * 当前栅栏的涂色方案有两种:
     * 和前一个颜色相同，此时说明前一个的栅栏的颜色应与更前面一个栅栏的颜色不同，更前一个栅栏的涂色方法有pprev种，前一个栅栏的涂色方式有(k - 1)种，所以此时情况应为pprev*(k - 1)
     * 和前一个颜色不同，前一个栅栏的涂色方法有prev种，当前栅栏的涂色方式有(k - 1)种，此时情况应为prev*(k - 1)
     * 所以递推公式应为ans= prev*(k - 1) + pprev*(k - 1)
     */
    public int numWays(int n, int k) {
        if (n == 0 || k == 0) {
            return 0;
        }
        if (n == 1) {
            return k;
        }
        int ans = 0;
        int pprev = k;
        int prev = k * k;
        for (int i = 2; i < n; i++) {
            ans = pprev * (k - 1) + prev * (k - 1);
            pprev = prev;
            prev = ans;
        }
        return ans;
    }
}
