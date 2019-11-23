package com.tuhailong.leetcode;

import java.util.Arrays;

/**
 * 假设存在一个 k 位数 N，其每一位上的数字的 k 次幂的总和也是 N，那么这个数是阿姆斯特朗数。
 * 给你一个正整数 N，让你来判定他是否是阿姆斯特朗数，是则返回 true，不是则返回 false。
 * 示例 1：
 * 输入：153
 * 输出：true
 * 示例：
 * 153 是一个 3 位数，且 153 = 1^3 + 5^3 + 3^3。
 * 示例 2：
 * 输入：123
 * 输出：false
 * 解释：
 * 123 是一个 3 位数，且 123 != 1^3 + 2^3 + 3^3 = 36。
 * 提示：
 * 1 <= N <= 10^8
 * 链接：https://leetcode-cn.com/problems/armstrong-number
 */
public class LeetCode1134 {
    public boolean isArmstrong(int N) {
        if (N <= 0) {
            return false;
        }
        int[] nums = new int[9];
        Arrays.fill(nums, -1);
        int idx = 0;
        int n = N;
        while (n != 0) {
            nums[idx++] = n % 10;
            n /= 10;
        }
        int sum = 0;
        final int len = idx;
        for (int num : nums) {
            if (num == -1) {
                break;
            }
            idx = len;
            int power = num;
            while (--idx != 0) {
                power = power * num;
            }
            sum += power;
        }
        return sum == N;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode1134().isArmstrong(153));
    }
}
