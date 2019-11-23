package com.tuhailong.leetcode;

import java.util.ArrayList;

/**
 * 给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算其所有整数的移动平均值。
 *
 * 示例:
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 *
 * 链接：https://leetcode-cn.com/problems/moving-average-from-data-stream
 */
public class LeetCode346 {
    class MovingAverage {
        private int mWindowLength;
        private final ArrayList<Integer> list = new ArrayList<>();

        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            mWindowLength = size;
        }

        public double next(int val) {
            list.add(val);
            int len = list.size();
            int cnt = mWindowLength;
            if (len < mWindowLength) {
                cnt = len;
            }
            double sum = 0.0;
            int tmp = cnt;
            while (tmp != 0) {
                sum += list.get(len - tmp);
                --tmp;
            }
            return sum / cnt;
        }
    }
}
