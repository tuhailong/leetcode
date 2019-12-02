package com.tuhailong.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个排序的整数数组 nums ，其中元素的范围在 闭区间 [lower, upper] 当中，返回不包含在数组中的缺失区间。
 * 示例：
 * 输入: nums = [0, 1, 3, 50, 75], lower = 0 和 upper = 99,
 * 输出: ["2", "4->49", "51->74", "76->99"]
 * 链接：https://leetcode-cn.com/problems/missing-ranges
 *
 * @author tuhailong
 * @since 2019-11-30
 */
public class LeetCode163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        long left = lower;
        long right = upper;
        int len = nums.length;
        // nums为null或长度为0
        if (nums == null || len == 0) {
            // 将[lower, upper]加到列表中
            addToList(ans, left - 1, right + 1);
            return ans;
        }
        // 将[lower，nums[0])加入列表中
        addToList(ans, left - 1, nums[0]);
        for (int i = 1; i < len; i++) {
            addToList(ans, nums[i - 1], nums[i]);
        }
        // 将[nums[len - 1] + 1，upper)加入列表中
        addToList(ans, nums[len - 1], right + 1);
        return ans;
    }

    private void addToList(List<String> list, long left, long right) {
        if (left == right || left + 1 == right) {
            return;
        } else if (left + 1 == right - 1) {
            list.add(String.valueOf(left + 1));
        } else {
            list.add((left + 1) + "->" + (right - 1));
        }
    }

    public static void main(String[] args) {
        LeetCode163 ni = new LeetCode163();
        ni.findMissingRanges(new int[]{0, 1, 3, 50, 75}, -99, 99);
    }
}
