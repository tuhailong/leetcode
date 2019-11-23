package com.tuhailong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给出字符串text和字符串列表 words, 返回所有的索引对[i, j]使得在索引对范围内的子字符串text[i]...text[j]（包括 i 和 j）属于字符串列表 words。
 * 示例 1:
 * 输入: text = "thestoryofleetcodeandme", words = ["story","fleet","leetcode"]
 * 输出: [[3,7],[9,13],[10,17]]
 * 示例 2:
 * 输入: text = "ababa", words = ["aba","ab"]
 * 输出: [[0,1],[0,2],[2,3],[2,4]]
 * 解释:
 * 注意，返回的配对可以有交叉，比如，"aba" 既在 [0,2] 中也在 [2,4] 中
 * 提示:
 * 所有字符串都只包含小写字母。
 * 保证 words 中的字符串无重复。
 * 1 <= text.length <= 100
 * 1 <= words.length <= 20
 * 1 <= words[i].length <= 50
 * 按序返回索引对 [i,j]（即，按照索引对的第一个索引进行排序，当第一个索引对相同时按照第二个索引对排序）。
 * 链接：https://leetcode-cn.com/problems/index-pairs-of-a-string
 *
 * @author tuhailong
 * @since 2019-11-22
 */
class LeetCode1065 {
    public int[][] indexPairs(String text, String[] words) {
        ArrayList<int[]> list = new ArrayList<>();
        for (String word : words) {
            int len = word.length();
            int idx = text.indexOf(word, 0);
            while (idx != -1) {
                list.add(new int[]{idx, idx + len - 1});
                idx = text.indexOf(word, idx + 1);
            }
        }
        int[][] rets = list.toArray(new int[0][]);
        Arrays.sort(rets, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        return rets;
    }
}
