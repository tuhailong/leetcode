package com.tuhailong.leetcode;

import javafx.util.Pair;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 *
 * @author tuhailong
 * @since 2019-11-14
 */
class LeetCode111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int curDepth = 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 1));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            curDepth = pair.getValue();
            if (node.left == null && node.right == null) {
                break;
            }
            if (node.left != null) {
                queue.offer(new Pair<>(node.left, curDepth + 1));
            }
            if (node.right != null) {
                queue.offer(new Pair<>(node.right, curDepth + 1));
            }
        }
        return curDepth;
    }
}
