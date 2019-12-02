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
        Map<String, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            ArrayList<Integer> list = map.getOrDefault(words[i], new ArrayList<>());
            list.add(i);
            map.put(words[i], list);
        }
        int min = Integer.MAX_VALUE;
        ArrayList<Integer> list1 = map.get(word1);
        int len1 = list1.size();
        if (word1.equals(word2)) {
            for (int i = 1; i < len1; i++) {
                min = Math.min(list1.get(i) - list1.get(i - 1), min);
            }
            return min;
        }
        ArrayList<Integer> list2 = map.get(word2);
        int len2 = list2.size();
        int idx1 = 0;
        int idx2 = 0;
        while (idx1 < len1 && idx2 < len2) {
            min = Math.min(Math.abs(list1.get(idx1) - list2.get(idx2)), min);
            if (list1.get(idx1) < list2.get(idx2)) {
                ++idx1;
            } else {
                ++idx2;
            }
        }
        return min;
    }

    public int shortestWordDistanceFaster(String[] words, String word1, String word2) {
        int len = words.length;
        int idx1 = -len;
        int idx2 = -len;
        int min = Integer.MAX_VALUE;
        if (word1.equals(word2)) {
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1)) {
                    if (idx1 < idx2) {
                        idx1 = i;
                    } else {
                        idx2 = i;
                    }
                    min = Math.min(Math.abs(idx2 - idx1), min);
                }
            }
            return min;
        }
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                idx1 = i;
            } else if (words[i].equals(word2)) {
                idx2 = i;
            } else {
                continue;
            }
            min = Math.min(Math.abs(idx2 - idx1), min);
        }
        return min;
    }
}
