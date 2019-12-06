package com.tuhailong.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串s，返回其通过重新排列组合后所有可能的回文字符串，并去除重复的组合。
 * 如不能形成任何回文排列时，则返回一个空列表。
 * 示例 1：
 * 输入: "aabb"
 * 输出: ["abba", "baab"]
 * 示例 2：
 * 输入: "abc"
 * 输出: []
 * 链接：https://leetcode-cn.com/problems/palindrome-permutation-ii
 *
 * @author tuhailong
 * @since 2019-12-06
 */
class LeetCode267 {
    public List<String> generatePalindromes(String s) {
        List<String> ans = new ArrayList<>();
        char[] cnts = new char[128];
        if (!isPalindromes(s.toCharArray(), cnts)) {
            return ans;
        }
        int k = 0;
        char mid = 0;
        char[] part = new char[s.length() / 2];
        for (int i = 0; i < cnts.length; i++) {
            if (cnts[i] % 2 == 1) {
                mid = (char) i;
            }
            for (int j = 0; j < cnts[i] / 2; j++) {
                part[k++] = (char) i;
            }
        }
        searchPalindromes(ans, new boolean[part.length],
            new char[part.length], part, mid, 0);
        return ans;
    }

    private boolean isPalindromes(char[] chs, char[] cnts) {
        int count = 0;
        for (int i = 0; i < chs.length; i++) {
            cnts[chs[i]]++;
            if (cnts[chs[i]] % 2 == 0) {
                count--;
            } else {
                count++;
            }
        }
        return count <= 1;
    }

    public void searchPalindromes(List<String> ans, boolean[] visiable, char[] selected,
            char[] part, char middle, int left) {
        if (left == part.length) {
            StringBuilder builder = new StringBuilder(String.valueOf(selected));
            ans.add(String.valueOf(selected) + (middle == 0 ? "" : String.valueOf(middle)) + builder.reverse());
            return;
        }
        for (int i = 0; i < part.length; i++) {
            if (i > 0 && !visiable[i - 1] && part[i] == part[i - 1]) {
                continue;
            }
            if (!visiable[i]) {
                visiable[i] = true;
                selected[left] = part[i];
                searchPalindromes(ans, visiable, selected, part, middle, left + 1);
                visiable[i] = false;
            }
        }
    }
}
