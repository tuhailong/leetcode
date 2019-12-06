package com.tuhailong.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 给出一个字符串 S，考虑其所有重复子串（S 的连续子串，出现两次或多次，可能会有重叠）。
 * 返回任何具有最长可能长度的重复子串。（如果 S 不含重复子串，那么答案为 ""。）
 * 示例 1：
 * 输入："banana"
 * 输出："ana"
 * 示例 2：
 * 输入："abcd"
 * 输出：""
 * 提示：
 * 2 <= S.length <= 10^5
 * S由小写英文字母组成。
 * 链接：https://leetcode-cn.com/problems/longest-duplicate-substring
 *
 * @author tuhailong
 * @since 2019-12-05
 */
class LeetCode1044 {
    // 效率差，待改进
    public String longestDupSubstring(String S) {
        String ans = "";
        char[] chs = S.toCharArray();
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < chs.length; i++) {
            List<Integer> list  = map.get(chs[i]);
            if (list == null) {
                list = new ArrayList<>();
                map.put(chs[i], list);
            }
            list.add(i);
        }
        for (char i = 'a'; i <= 'z' ; i++) {
            List<Integer> list = map.get(i);
            if (list == null) {
                continue;
            }
            if (list.size() == 1) {
                map.remove(i);
            }
        }
        if (map.size() == 0) {
            return ans;
        }
        int max = Integer.MIN_VALUE;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chs.length - 1; i++) {
            if (map.get(chs[i]) == null) {
                builder.delete(0, builder.length());
                continue;
            }
            int j = i;
            while (j < chs.length) {
                builder.append(chs[j]);
                int idx = S.indexOf(builder.toString(), i + 1);
                if (idx == -1) {
                    builder.delete(0, builder.length());
                    break;
                }
                ++j;
                if (max >= builder.length()) {
                    continue;
                }
                max = builder.length();
                ans = builder.toString();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1044 ni = new LeetCode1044();
        System.out.println(ni.longestDupSubstring("banana"));
    }
}