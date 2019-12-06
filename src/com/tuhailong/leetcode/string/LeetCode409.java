package com.tuhailong.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * 注意:
 * 假设字符串的长度不会超过 1010。
 * 示例 1:
 * 输入:
 * "abccccdd"
 * 输出:
 * 7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * 链接：https://leetcode-cn.com/problems/longest-palindrome
 *
 * @author tuhailong
 * @since 2019-12-06
 */
class LeetCode409 {
    public int longestPalindrome(String s) {
        char[] chs = s.toCharArray();
        char[] cnts = new char[128];
        for (int i = 0; i < chs.length; i++) {
            ++cnts[chs[i]];
        }
        int count = 0;
        int oddMax = 0;
        for (int cnt : cnts) {
            if (cnt == 0) {
                continue;
            }
            if (cnt % 2 == 0) {
                count += cnt;
            } else {
                if (oddMax < cnt) {
                    count += ((oddMax == 0) ? 0 : oddMax - 1);
                    oddMax = cnt;
                } else {
                    count += (cnt - 1);
                }
            }
        }
        return count + oddMax;
    }

    public int longestPalindromeMine(String s) {
        char[] chs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chs.length; i++) {
            map.put(chs[i], map.getOrDefault(chs[i], 0) + 1);
        }
        int count = 0;
        int oddMax = 0;
        for (int cnt : map.values()) {
            if (cnt % 2 == 0) {
                count += cnt;
            } else {
                if (oddMax < cnt) {
                    count += (oddMax == 0 ? 0 : (oddMax - 1));
                    oddMax = cnt;
                } else {
                    count += (cnt - 1);
                }
            }
        }
        return count + oddMax;
    }

    public static void main(String[] args) {
        LeetCode409 ni = new LeetCode409();
        System.out.println(ni.longestPalindrome("abccccdd"));
    }
}