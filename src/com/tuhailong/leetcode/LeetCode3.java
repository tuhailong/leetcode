package com.tuhailong.leetcode;

import java.util.HashSet;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 *
 * @author tuhailong
 * @since 2019-10-29
 */
class LeetCode3 {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int len = s.length();
        int rid = 0;
        int lid = 0;
        int ans = 0;
        HashSet<Character> set = new HashSet<>();
        while (rid < len && lid < len) {
            if (!set.contains(s.charAt(lid))) {
                set.add(s.charAt(lid++));
                ans = Math.max(lid - rid, ans);
            } else {
                set.remove(s.charAt(rid++));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
