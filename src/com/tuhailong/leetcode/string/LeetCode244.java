package com.tuhailong.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 请设计一个类，使该类的构造函数能够接收一个单词列表。
 * 然后再实现一个方法，该方法能够分别接收两个单词 word1 和 word2，并返回列表中这两个单词之间的最短距离。
 * 您的方法将被以不同的参数调用多次。
 * 示例:
 * 假设 words = ["practice", "makes", "perfect", "coding", "makes"]
 * 输入: word1 = “coding”, word2 = “practice”
 * 输出: 3
 * 输入: word1 = "makes", word2 = "coding"
 * 输出: 1
 * 注意:
 * 你可以假设 word1 不等于 word2, 并且 word1 和 word2 都在列表里。
 * 链接：https://leetcode-cn.com/problems/shortest-word-distance-ii
 *
 * @author tuhailong
 * @since 2019-11-30
 */
public class LeetCode244 {
    class WordDistance {
        private final Map<String, ArrayList<Integer>> MAP = new HashMap<>();

        public WordDistance(String[] words) {
            for (int i = 0; i < words.length; i++) {
                ArrayList<Integer> list = MAP.getOrDefault(words[i], new ArrayList<>());
                list.add(i);
                MAP.put(words[i], list);
            }
        }

        public int shortest(String word1, String word2) {
            ArrayList<Integer> idxes1 = MAP.get(word1);
            ArrayList<Integer> idxes2 = MAP.get(word2);
            int len1 = idxes1.size();
            int len2 = idxes2.size();
            int idx1 = 0;
            int idx2 = 0;
            int min = Integer.MAX_VALUE;
            while (idx1 < len1 && idx2 < len2) {
                min = Math.min(Math.abs(idxes1.get(idx1) - idxes2.get(idx2)), min);
                if (idxes1.get(idx1) < idxes2.get(idx2)) {
                    ++idx1;
                } else {
                    ++idx2;
                }
            }
            return min;
        }
    }

    class WordDistanceMine {
        private String[] mWords;

        public WordDistanceMine(String[] words) {
            mWords = words;
        }

        public int shortest(String word1, String word2) {
            int idx1 = -1;
            int idx2 = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < mWords.length; i++) {
                if (mWords[i].equals(word1)) {
                    idx1 = i;
                    if (idx2 == -1) {
                        continue;
                    }
                    min = Math.min(Math.abs(idx1 - idx2), min);
                    continue;
                }
                if (mWords[i].equals(word2)) {
                    idx2 = i;
                    if (idx1 == -1) {
                        continue;
                    }
                    min = Math.min(Math.abs(idx1 - idx2), min);
                    continue;
                }
            }
            return min;
        }
    }
}
