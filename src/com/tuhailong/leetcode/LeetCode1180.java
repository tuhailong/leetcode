package com.tuhailong.leetcode;

/**
 * 给你一个字符串 S，返回只含 单一字母 的子串个数。
 * 示例 1：
 * 输入： "aaaba"
 * 输出： 8
 * 解释：
 * 只含单一字母的子串分别是 "aaa"， "aa"， "a"， "b"。
 * "aaa" 出现 1 次。
 * "aa" 出现 2 次。
 * "a" 出现 4 次。
 * "b" 出现 1 次。
 * 所以答案是 1 + 2 + 4 + 1 = 8。
 * 示例 2:
 * 输入： "aaaaaaaaaa"
 * 输出： 55
 * 提示：
 * 1 <= S.length <= 1000
 * S[i] 仅由小写英文字母组成。
 * 链接：https://leetcode-cn.com/problems/count-substrings-with-only-one-distinct-letter
 */
public class LeetCode1180 {
    public int countLetters(String S) {
        int ret = 0;
        char[] chs = S.toCharArray();
        int idx = 0;
        while (idx < chs.length) {
            int cnt = 1;
            while (idx + 1 < chs.length && chs[idx] == chs[idx + 1]) {
                ++cnt;
                ++idx;
            }
            ret += (cnt * (cnt + 1) / 2);
            ++idx;
        }
        return ret;
    }
}
