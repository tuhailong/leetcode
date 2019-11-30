package com.tuhailong.leetcode.string;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 给定两个字符串 s 和 t，判断他们的编辑距离是否为 1。
 * 注意：
 * 满足编辑距离等于 1 有三种可能的情形：
 * 往 s 中插入一个字符得到 t
 * 从 s 中删除一个字符得到 t
 * 在 s 中替换一个字符得到 t
 * 示例 1：
 * 输入: s = "ab", t = "acb"
 * 输出: true
 * 解释: 可以将 'c' 插入字符串 s 来得到 t。
 * 示例 2:
 * 输入: s = "cab", t = "ad"
 * 输出: false
 * 解释: 无法通过 1 步操作使 s 变为 t。
 * 示例 3:
 * 输入: s = "1203", t = "1213"
 * 输出: true
 * 解释: 可以将字符串 s 中的 '0' 替换为 '1' 来得到 t。
 * 链接：https://leetcode-cn.com/problems/one-edit-distance
 *
 * @author tuhailong
 * @since 2019-11-30
 */
class LeetCode161 {
    public boolean isOneEditDistance(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        // 两个字符串的长度差值大于1的编辑距离大于1
        if (Math.abs(slen - tlen) > 1) {
            return false;
        }
        // 两个字符串的长度差值为0：
        // 两个字符串中只有一个位置的字符不一致, 编辑距离为1.
        if (slen == tlen) {
            int diff = 0;
            for (int i = 0; i < slen; i++) {
                if (s.charAt(i) == t.charAt(i)) {
                    continue;
                }
                if (++diff > 1) {
                    break;
                }
            }
            return diff == 1;
        }
        // 两个字符串的长度差值为1：
        // 短串的每个字符都在长串中，且递增出现在长串中
        String ls = slen > tlen ? s : t;
        String ss = slen < tlen ? s : t;
        int minLen = ss.length();
        int idx = -1;
        for (int i = 0; i < minLen; i++) {
            idx = ls.indexOf(ss.charAt(i), idx + 1);
            if (idx == -1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode161 ni = new LeetCode161();
        System.out.println(ni.isOneEditDistance("ab", "acd"));
    }
}
