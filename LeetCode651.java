package com.tuhailong.leetcode.greedy;

/**
 * 假设你有一个特殊的键盘包含下面的按键：
 * Key 1: (A)：在屏幕上打印一个 'A'。
 * Key 2: (Ctrl-A)：选中整个屏幕。
 * Key 3: (Ctrl-C)：复制选中区域到缓冲区。
 * Key 4: (Ctrl-V)：将缓冲区内容输出到上次输入的结束位置，并显示在屏幕上。
 * 现在，你只可以按键 N 次（使用上述四种按键），请问屏幕上最多可以显示几个 'A'呢？
 * 样例 1:
 * 输入: N = 3
 * 输出: 3
 * 解释:
 * 我们最多可以在屏幕上显示三个'A'通过如下顺序按键：
 * A, A, A
 * 样例 2:
 * 输入: N = 7
 * 输出: 9
 * 解释:
 * 我们最多可以在屏幕上显示九个'A'通过如下顺序按键：
 * A, A, A, Ctrl A, Ctrl C, Ctrl V, Ctrl V
 * 注释:
 * 1 <= N <= 50
 * 结果不会超过 32 位有符号整数范围。
 * 链接：https://leetcode-cn.com/problems/4-keys-keyboard
 *
 * @author t00278867
 * @since 2019-11-23
 */
class LeetCode651 {
    /**
     * 解题思路：贪心算法
     * 每一步都确保是直至当前为止的最优解（局部最优解），由开始递推到最后（局部递推到全局），便可得到全局最优解。
     * 每一步按键都有2种可能：
     *  1.按下KEY1，增加一个"A"；
     *  2.按下KEY4，将已有的内容粘贴一份。
     * 因为在按下KEY4之前需要先按下KEY2+KEY3，因此在考虑按KEY4的时候先默认减少2次按键机会（j从2开始递增）。
     * 每走一步，都比较前面按下KEY1和KEY4的情况下哪个值更大，更大的即是当前的局部最优解。
     * 得到局部最优解后则当前步完成，以同样的方法向后推进。
     */
    public int maxA(int N) {
        if (N < 7) {
            return N;
        }
        int[] cnts = new int[N + 1];
        cnts[0] = 0;
        for (int i = 1; i < cnts.length; i++) {
            cnts[i] = cnts[i - 1] + 1;
            for (int j = 2; j + 1 < i; j++) {
                cnts[i] = Math.max(cnts[i], cnts[j - 1] * (i - j));
            }
        }
        return cnts[N];
    }
}