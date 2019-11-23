package com.tuhailong.leetcode;

/**
 * 给一个 非空 字符串 s 和一个单词缩写 abbr ，判断这个缩写是否可以是给定单词的缩写。
 * 字符串 "word" 的所有有效缩写为：
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 * 注意单词 "word" 的所有有效缩写仅包含以上这些。任何其他的字符串都不是 "word" 的有效缩写。
 * 注意:
 * 假设字符串 s 仅包含小写字母且 abbr 只包含小写字母和数字。
 * 示例 1:
 * 给定 s = "internationalization", abbr = "i12iz4n":
 * 函数返回 true.
 * 示例 2:
 * 给定 s = "apple", abbr = "a2e":
 * 函数返回 false.
 * 链接：https://leetcode-cn.com/problems/valid-word-abbreviation
 *
 * @author tuhailong
 * @since 2019-11-20
 */
class LeetCode408 {
    public boolean validWordAbbreviation(String word, String abbr) {
        if (word == null && abbr == null) {
            return true;
        }
        if (word == null || abbr == null) {
            return false;
        }
        StringBuilder builder = new StringBuilder();
        char[] wchs = word.toCharArray();
        char[] tmps = abbr.toCharArray();
        int i = 0;
        while (i < tmps.length) {
            if (Character.isLetter(tmps[i])) {
                builder.append(tmps[i]);
                ++i;
                continue;
            }
            // 缩写的字母后面紧跟0为非法缩写
            if (tmps[i] == '0') {
                return false;
            }
            int tmp = 0;
            while (i < tmps.length && Character.isDigit(tmps[i])) {
                tmp = tmp * 10 + (tmps[i] - '0');
                ++i;
            }
            // 缩写长度大于原本字符串长度的为非法缩写
            if (tmp > wchs.length) {
                return false;
            }
            for (int j = 0; j < tmp; j++) {
                builder.append('0');
            }
        }
        char[] achs = builder.toString().toCharArray();
        if (wchs.length != achs.length) {
            return false;
        }
        for (i = 0; i < wchs.length; i++) {
            if (achs[i] == '0') {
                continue;
            }
            if (achs[i] != wchs[i]) {
                return false;
            }
        }
        return true;
    }
}
