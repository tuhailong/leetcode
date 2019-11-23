package com.tuhailong.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个单词序列，判断其是否形成了一个有效的单词方块。
 * 有效的单词方块是指此由单词序列组成的文字方块的 第 k 行 和 第 k 列 (0 ≤ k < max(行数, 列数)) 所显示的字符串完全相同。
 * 注意：
 * 给定的单词数大于等于 1 且不超过 500。
 * 单词长度大于等于 1 且不超过 500。
 * 每个单词只包含小写英文字母 a-z。
 * 示例 1：
 * 输入：
 * [
 *   "abcd",
 *   "bnrt",
 *   "crmy",
 *   "dtye"
 * ]
 * 输出：
 * true
 * 解释：
 * 第 1 行和第 1 列都是 "abcd"。
 * 第 2 行和第 2 列都是 "bnrt"。
 * 第 3 行和第 3 列都是 "crmy"。
 * 第 4 行和第 4 列都是 "dtye"。
 * 因此，这是一个有效的单词方块。
 * 示例 2：
 * 输入：
 * [
 *   "abcd",
 *   "bnrt",
 *   "crm",
 *   "dt"
 * ]
 * 输出：
 * true
 * 解释：
 * 第 1 行和第 1 列都是 "abcd"。
 * 第 2 行和第 2 列都是 "bnrt"。
 * 第 3 行和第 3 列都是 "crm"。
 * 第 4 行和第 4 列都是 "dt"。
 * 因此，这是一个有效的单词方块。
 * 示例 3：
 * 输入：
 * [
 *   "ball",
 *   "area",
 *   "read",
 *   "lady"
 * ]
 * 输出：
 * false
 * 解释：
 * 第 3 行是 "read" ，然而第 3 列是 "lead"。
 * 因此，这 不是 一个有效的单词方块。
 * 链接：https://leetcode-cn.com/problems/valid-word-square
 *
 * @author tuhailong
 * @since 2019-11-20
 */
class LeetCode422 {
    public boolean validWordSquare(List<String> words) {
        if (words.isEmpty()) {
            return true;
        }
        int rlen = words.size();
        for (int rid = 0; rid < rlen; rid++) {
            int clen = words.get(rid).length();
            for (int cid = 0; cid < clen; cid++) {
                if (rlen < cid
                    || words.get(cid).length() <= rid
                    || words.get(cid).charAt(rid) != words.get(rid).charAt(cid)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean validWordSquareOpted(List<String> words) {
        if (words.isEmpty()) {
            return true;
        }
        int n = words.size();
        char[][] chs = new char[n][n];
        int i = 0;
        for (String word : words) {
            if (word.length() > n) {
                return false;
            }
            System.arraycopy(word.toCharArray(), 0, chs[i++], 0, word.length());
        }
        for (i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (chs[i][j] != chs[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("abcd");
        words.add("bnrt");
        words.add("crm");
        words.add("dt");
        LeetCode422 ni = new LeetCode422();
        System.out.println(ni.validWordSquareOpted(words));
    }
}
