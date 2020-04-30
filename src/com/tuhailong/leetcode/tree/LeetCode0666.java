package com.tuhailong.leetcode.tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 路径和 IV
 *
 * 对于一棵深度小于 5 的树，可以用一组三位十进制整数来表示。
 * 对于每个整数：
 *   百位上的数字表示这个节点的深度 D，1 <= D <= 4。
 *   十位上的数字表示这个节点在当前层所在的位置 P， 1 <= P <= 8。位置编号与一棵满二叉树的位置编号相同。
 *   个位上的数字表示这个节点的权值 V，0 <= V <= 9。
 * 给定一个包含三位整数的升序数组，表示一棵深度小于 5 的二叉树，请你返回从根到所有叶子结点的路径之和。
 * 样例 1:
 * 输入: [113, 215, 221]
 * 输出: 12
 * 解释:
 * 这棵树形状如下:
 *     3
 *    / \
 *   5   1
 * 路径和 = (3 + 5) + (3 + 1) = 12.
 * 样例 2:
 * 输入: [113, 221]
 * 输出: 4
 * 解释:
 * 这棵树形状如下:
 *     3
 *      \
 *       1
 * 路径和 = (3 + 1) = 4.
 *
 * 链接：https://leetcode-cn.com/problems/path-sum-iv
 *
 * @author tuhailong
 * @since 2020-04-30
 */
public class LeetCode0666 {
    public int pathSum(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int[] ans = new int[1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num / 10, num % 10);
        }
        dfs(nums[0] / 10, 0, ans, map);
        return ans[0];
    }

    private void dfs(int node, int sum, int[] ans, Map<Integer, Integer> map) {
        if (!map.containsKey(node)) {
            return;
        }
        sum += map.get(node);

        int depth = node / 10;
        int index = node % 10;
        int left = (depth + 1) * 10 + 2 * index - 1;
        int right = left + 1;

        if (!map.containsKey(left) && !map.containsKey(right)) {
            ans[0] += sum;
        } else {
            dfs(left, sum, ans, map);
            dfs(right, sum, ans, map);
        }
    }
}
