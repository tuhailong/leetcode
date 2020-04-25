package com.tuhailong.leetcode;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 *
 * @author tuhailong
 * @since 2019-10-30
 */
class LeetCode5 {
    // 动态规划
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        int len = s.length();
        int max = 1;
        int rid = 0;
        int lid = 0;
        boolean[][] dp = new boolean[len][len];
        for (int j = 0; j < len; j++) {
            dp[j][j] = true;
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    if (dp[i][j] && (j - i + 1) > max) {
                        max = j - i + 1;
                        rid = i;
                        lid = j;
                    }
                }
            }
        }
        return s.substring(rid, lid + 1);
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode5().longestPalindrome("aaaa"));
    }
}
