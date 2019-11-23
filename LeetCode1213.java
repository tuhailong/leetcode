package com.tuhailong.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出三个均为 严格递增排列 的整数数组 arr1，arr2 和 arr3。
 * 返回一个由 仅 在这三个数组中 同时出现 的整数所构成的有序数组。
 * 示例：
 * 输入: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
 * 输出: [1,5]
 * 解释: 只有 1 和 5 同时在这三个数组中出现.
 * 提示：
 * 1 <= arr1.length, arr2.length, arr3.length <= 1000
 * 1 <= arr1[i], arr2[i], arr3[i] <= 2000
 * 链接：https://leetcode-cn.com/problems/intersection-of-three-sorted-arrays
 */
public class LeetCode1213 {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int[] map = new int[2001];
        for (int n : arr1) {
            ++map[n];
        }
        for (int n : arr2) {
            ++map[n];
        }
        for (int n : arr3) {
            ++map[n];
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 3) {
                list.add(i);
            }
        }
        return list;
    }

}
