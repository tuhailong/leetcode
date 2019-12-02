package com.tuhailong.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 说明：
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(nlogn) , n 是数组的大小。
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 *
 * @author tuhailong
 * @since 2019-11-25
 */
class LeetCode347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        ArrayList<int[]> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(new int[]{entry.getKey(), entry.getValue()});
        }
        Collections.sort(list, (o1, o2) -> o2[1] - o1[1]);
        List<Integer> ans = new ArrayList<>();
        while (k-- > 0) {
            ans.add(list.remove(0)[0]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        LeetCode347 ni = new LeetCode347();
        System.out.println(ni.topKFrequent(nums, 2).toString());
    }
}
