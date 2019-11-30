package com.tuhailong.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 给定一个字符串s，找出 至多 包含两个不同字符的最长子串t。
 * 示例 1:
 * 输入: "eceba"
 * 输出: 3
 * 解释: t 是 "ece"，长度为3。
 * 示例 2:
 * 输入: "ccaabbb"
 * 输出: 5
 * 解释: t 是 "aabbb"，长度为5。
 * 链接：https://leetcode-cn.com/problems/longest-substring-with-at-most-two-distinct-characters
 *
 * @author tuhailong
 * @since 2019-11-29
 */
public class LeetCode159 {
    /**
     * 解题思路：滑动窗口
     *  使用一个左指针和一个右指针表示滑动窗口的边界。
     *  一开始，让两个指针都指向0，当窗口包含的字符不超过2个不同的字符时，就不断将右指针往右边移动。
     *  如果在某一个位置有3个不同的字符，就开始移动左指针，直到窗口内包含不超过2个不同字符。
     *  使用一个hashmap，把字符串里的字符都当做键，将窗口两侧的字符位置当做值，任意时刻，该hashmap的size都不超过3个元素。
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int len = s.length();
        if (len < 3) {
            return len;
        }
        // 滑动窗口的左指针初始位置
        int lid = 0;
        // 滑动窗口的右指针初始位置
        int rid = 0;
        char[] chs = s.toCharArray();
        // 字符串里的字符都当做键，将窗口两侧的字符位置当做值，任意时刻，该map的size都不大于3
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 2;
        while (rid < len) {
            // 窗口中的字符数量小于3，直接添加到map中
            if (map.size() < 3) {
                map.put(chs[rid], rid++);
            }
            // 窗口中的字符数量为3时，移除窗口最左侧的字符
            if (map.size() == 3) {
                int delIdx = Collections.min(map.values());
                map.remove(chs[delIdx]);
                // 移动窗口左指针
                lid = delIdx + 1;
            }
            max = Math.max(max, rid - lid);
        }
        return max;
    }

    public int lengthOfLongestSubstringTwoDistinctMine(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int len = s.length();
        if (len <= 2) {
            return len;
        }
        int max = Integer.MIN_VALUE;
        char[] chs = s.toCharArray();
        for (int i = 0; i < len; i++) {
            if (i > 0 && chs[i] == chs[i - 1]) {
                continue;
            }
            int cnt = 0;
            HashSet<Character> set = new HashSet<>();
            for (int j = i; j < len; j++) {
                set.add(chs[j]);
                if (set.size() > 2) {
                    break;
                }
                ++cnt;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode159 ni = new LeetCode159();
        System.out.println(ni.lengthOfLongestSubstringTwoDistinct("abdcccccccccccccccccccccccc"));
    }
}
