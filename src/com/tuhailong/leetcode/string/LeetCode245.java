package com.tuhailong.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个单词列表和两个单词 word1 和 word2，返回列表中这两个单词之间的最短距离。
 * word1 和 word2 是有可能相同的，并且它们将分别表示为列表中两个独立的单词。
 * 示例:
 * 假设 words = ["practice", "makes", "perfect", "coding", "makes"].
 * 输入: word1 = “makes”, word2 = “coding”
 * 输出: 1
 * 输入: word1 = "makes", word2 = "makes"
 * 输出: 3
 * 注意:
 * 你可以假设 word1 和 word2 都在列表里。
 * 链接：https://leetcode-cn.com/problems/shortest-word-distance-iii
 *
 * @author tuhailong
 * @since 2019-11-30
 */
public class LeetCode245 {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int len = words.length;
        int min = Integer.MAX_VALUE;
        int idx1 = -len;
        if (word1.equals(word2)) {
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1)) {
                    min = Math.min(i - idx1, min);
                    idx1 = i;
                }
            }
            return min;
        }
        int idx2 = -len;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                idx1 = i;
            } else if (words[i].equals(word2)) {
                idx2 = i;
            } else {
                continue;
            }
            min = Math.min(Math.abs(idx1 - idx2), min);
        }
        return min;
    }

    public static void main(String[] args) {
        LeetCode245 ni = new LeetCode245();
        System.out.println(ni.shortestWordDistance(new String[] {"practice", "makes", "perfect", "coding", "makes"}, "makes", "makes"));
    }
}
