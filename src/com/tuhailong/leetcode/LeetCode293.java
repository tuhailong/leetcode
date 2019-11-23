package com.tuhailong.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 你和朋友玩一个叫做「翻转游戏」的游戏，游戏规则：给定一个只有+和-的字符串。
 * 你和朋友轮流将连续的两个"++" 反转成"--"。
 * 当一方无法进行有效的翻转时便意味着游戏结束，则另一方获胜。
 * 请你写出一个函数，来计算出每个有效操作后，字符串所有的可能状态。
 * 示例：
 * 输入: s = "++++"
 * 输出:
 * [
 *   "--++",
 *   "+--+",
 *   "++--"
 * ]
 * 注意：如果不存在可能的有效操作，请返回一个空列表 []。
 * 链接：https://leetcode-cn.com/problems/flip-game
 */

public class LeetCode293 {
    public List<String> generatePossibleNextMoves(String s) {
        if (s == null || s.isEmpty() || s.length() == 1) {
            return Collections.emptyList();
        }
        List<String> ans = new ArrayList<>();
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length - 1; i++) {
            if (chs[i] == '+' && chs[i + 1] == '+') {
                chs[i] = '-';
                chs[i + 1] = '-';
                ans.add(new String(chs));
                chs[i] = '+';
                chs[i + 1] = '+';
            }
        }
        return ans;
    }
}
