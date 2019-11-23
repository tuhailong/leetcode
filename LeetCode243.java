package com.tuhailong.leetcode;

/**
 * 给定一个单词列表和两个单词 word1 和 word2，返回列表中这两个单词之间的最短距离。
 * 示例:
 * 假设 words = ["practice", "makes", "perfect", "coding", "makes"]
 * 输入: word1 = “coding”, word2 = “practice”
 * 输出: 3
 * 输入: word1 = "makes", word2 = "coding"
 * 输出: 1
 * 注意:
 * 你可以假设 word1 不等于 word2, 并且 word1 和 word2 都在列表里。
 * 链接：https://leetcode-cn.com/problems/shortest-word-distance
 *
 * @author tuhailong
 * @since 2019-11-18
 */
class LeetCode243 {
    public int shortestDistance(String[] words, String word1, String word2) {
        int ans = Integer.MAX_VALUE;
        int idx1 = -1;
        int idx2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                idx1 = i;
                if (idx2 == -1) {
                    continue;
                }
                ans = Math.min(ans, Math.abs(idx1 - idx2));
                continue;
            }
            if (words[i].equals(word2)) {
                idx2 = i;
                if (idx1 == -1) {
                    continue;
                }
                ans = Math.min(ans, Math.abs(idx1 - idx2));
                continue;
            }
        }
        return ans;
    }
}
