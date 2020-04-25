package com.tuhailong.leetcode;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 完全平方数
 *
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
 * 你需要让组成和的完全平方数的个数最少。
 * 示例 1:
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 *
 * 链接：https://leetcode-cn.com/problems/perfect-squares
 *
 * @author tuhailong
 * @since 2020-04-22
 */
public class LeetCode0297 {

    /**
     * perfect-squares
     *
     * @param num the given number
     * @return the min count
     */
    public int numSquares(int num) {
        if (num <= 1) {
            return num;
        }

        ArrayList<Integer> squares = new ArrayList<>();
        for (int i = 1; i * i <= num; i++) {
            squares.add(i * i);
        }

        HashSet<Integer> queue = new HashSet<>();
        queue.add(num);

        int level = 0;

        while (queue.size() > 0) {
            level += 1;
            HashSet<Integer> nextQueue = new HashSet<>();
            for (Integer remain : queue) {
                for (Integer square : squares) {
                    if (remain.intValue() < square.intValue()) {
                        break;
                    } else if (remain.intValue() == square.intValue()) {
                        return level;
                    } else {
                        nextQueue.add(remain.intValue() - square.intValue());
                    }
                }
            }
            queue = nextQueue;
        }

        return level;
    }
}
