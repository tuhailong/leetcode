package com.tuhailong.leetcode;

/**
 * 给出一个32位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * 注意:
 * 假设我们的环境只能存储得下32位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回0。
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 *
 * @author tuhailong
 * @since 2019-10-30
 */
class LeetCode7 {
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            if (ans > Integer.MAX_VALUE / 10 || ans < Integer.MIN_VALUE / 10) {
                ans = 0;
                break;
            }
            ans = ans * 10 +  (x % 10);
            x /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode7().reverse(123));
    }
}
