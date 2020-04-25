package com.tuhailong.leetcode.tree;

import com.tuhailong.leetcode.TreeNode;

import java.util.Stack;

/**
 * 给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
 * 示例：
 * 输入: root = [4,2,6,1,3,null,null]
 * 输出: 1
 * 解释:
 * 注意，root是树结点对象(TreeNode object)，而不是数组。
 * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
 *           4
 *         /   \
 *       2      6
 *      / \
 *     1   3
 * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
 * 注意：
 * 二叉树的大小范围在 2 到 100。
 * 二叉树总是有效的，每个节点的值都是整数，且不重复。
 * 链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes
 *
 * @author tuhailong
 * @since 2019-11-26
 */
public class LeetCode0783 {
    public int minDiffInBST(TreeNode root) {
        int min = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastNode = null;
        while (root != null || !stack.isEmpty()) {
           while (root != null) {
               stack.push(root);
               root = root.left;
           }
           TreeNode node = stack.pop();
           if (lastNode != null) {
               int diff = Math.abs(node.val - lastNode.val);
               min = Math.min(min, diff);
           }
           lastNode = node;
           root = node.right;
        }
        return min;
    }
}
