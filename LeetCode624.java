package com.tuhailong.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定 m 个数组，每个数组都已经按照升序排好序了。现在你需要从两个不同的数组中选择两个整数（每个数组选一个）并且计算它们的距离。
 * 两个整数 a 和 b 之间的距离定义为它们差的绝对值 |a-b| 。
 * 你的任务就是去找到最大距离
 * 示例 1：
 * 输入：
 * [[1,2,3],
 *  [4,5],
 *  [1,2,3]]
 * 输出： 4
 * 解释：
 * 一种得到答案 4 的方法是从第一个数组或者第三个数组中选择 1，同时从第二个数组中选择 5 。
 * 注意：
 * 每个给定数组至少会有 1 个数字。列表中至少有两个非空数组。
 * 所有 m 个数组中的数字总数目在范围 [2, 10000] 内。
 * m 个数组中所有整数的范围在 [-10000, 10000] 内。
 * 链接：https://leetcode-cn.com/problems/maximum-distance-in-arrays
 *
 * @author tuhailong
 * @since 2019-11-21
 */
class LeetCode624 {
    public int maxDistance(List<List<Integer>> arrays) {
        if (arrays == null || arrays.isEmpty()) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int min2 = min;
        int max2 = max;
        int minIdx = -1;
        int maxIdx = -1;
        for (int i = arrays.size() - 1; i >= 0 ; i--) {
            List<Integer> array = arrays.get(i);
            if (array == null || array.isEmpty()) {
                continue;
            }
            int curMin = array.get(0);
            if (min > curMin) {
                min2 = min;
                min = curMin;
                minIdx = i;
            } else if (min2 > curMin) {
                min2 = curMin;
            }
            int curMax = array.get(array.size() - 1);
            if (max < curMax) {
                max2 = max;
                max = curMax;
                maxIdx = i;
            } else if (max2 < curMax) {
                max2 = curMax;
            }
        }
        if (minIdx != maxIdx) {
            return Math.abs(max - min);
        }
        return Math.max(Math.abs(max - min2), Math.abs(max2 - min));
    }

    public static void main(String[] args) {
        LeetCode624 ni = new LeetCode624();
        List<List<Integer>> arrays = new ArrayList<>();
        List<Integer> array = new ArrayList<>();
        array.add(2);
        array.add(3);
        arrays.add(array);
        array = new ArrayList<>();
        array.add(0);
        array.add(1);
        array.add(5);
        arrays.add(array);
        System.out.println(ni.maxDistance(arrays));
    }
}
