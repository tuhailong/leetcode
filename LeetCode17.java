package com.tuhailong.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 *
 * @author tuhailong
 * @since 2019-10-31
 */
class LeetCode17 {
    private static final String[] MAPPER = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits == null || digits.isEmpty()) {
            return ans;
        }
        ans.add("");
        int len = digits.length();
        for (int i = 0; i < len; i++) {
            while (ans.peek().length() == i) {
                String tmp = ans.remove();
                for (char ch : MAPPER[digits.charAt(i) - '0'].toCharArray()) {
                    ans.add(tmp + ch);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> ret = new LeetCode17().letterCombinations("23");
    }
}
