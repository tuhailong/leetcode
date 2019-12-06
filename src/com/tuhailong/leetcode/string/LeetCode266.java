package com.tuhailong.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，判断该字符串中是否可以通过重新排列组合，形成一个回文字符串。
 * 示例 1：
 * 输入: "code"
 * 输出: false
 * 示例 2：
 * 输入: "aab"
 * 输出: true
 * 示例 3：
 * 输入: "carerac"
 * 输出: true
 * 链接：https://leetcode-cn.com/problems/palindrome-permutation
 *
 * @author tuhailong
 * @since 2019-12-06
 */
class LeetCode266 {
    public boolean canPermutePalindrome(String s) {
        char[] chs = s.toCharArray();
        char[] cnts = new char[128];
        for (int i = 0; i < chs.length; i++) {
            ++cnts[chs[i]];
        }
        int oddCnt = 0;
        for (int i = 0; i < cnts.length; i++) {
            if (cnts[i] % 2 != 0) {
                if (++oddCnt > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean canPermutePalindromeMine(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        char[] chs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chs.length; i++) {
            map.put(chs[i], map.getOrDefault(chs[i], 0) + 1);
        }
        int oddCnt = 0;
        for (int cnt : map.values()) {
            if (cnt % 2 != 0) {
                if (++oddCnt > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
