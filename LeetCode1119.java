package com.tuhailong.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * 给你一个字符串 S，请你删去其中的所有元音字母（ 'a'，'e'，'i'，'o'，'u'），并返回这个新字符串。
 * 示例 1：
 * 输入："leetcodeisacommunityforcoders"
 * 输出："ltcdscmmntyfrcdrs"
 * 示例 2：
 * 输入："aeiou"
 * 输出：""
 * 提示：
 * S 仅由小写英文字母组成。
 * 1 <= S.length <= 1000
 * 链接：https://leetcode-cn.com/problems/remove-vowels-from-a-string
 */
public class LeetCode1119 {
    private static final HashSet<Character> VOWELS = new HashSet<>();
    static {
        VOWELS.add('a');
        VOWELS.add('e');
        VOWELS.add('i');
        VOWELS.add('o');
        VOWELS.add('u');
    }

    public String removeVowels(String S) {
        StringBuffer buffer = new StringBuffer();
        final char[] chs = S.toCharArray();
        for (char ch : chs) {
            if (VOWELS.contains(ch)) {
                continue;
            }
            buffer.append(ch);
        }
        return buffer.toString();
    }
}
