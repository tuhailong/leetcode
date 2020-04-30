package com.tuhailong.leetcode.tree;

import com.tuhailong.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 最大 BST 子树
 *
 * 给定一个二叉树，找到其中最大的二叉搜索树（BST）子树，其中最大指的是子树节点数最多的。
 * 注意:
 * 子树必须包含其所有后代。
 * 示例:
 * 输入: [10,5,15,1,8,null,7]
 *    10
 *    / \
 *   5  15
 *  / \   \
 * 1   8   7
 * 输出: 3
 * 解释: 高亮部分为最大的 BST 子树。
 *      返回值 3 在这个样例中为子树大小。
 * 进阶:
 * 你能想出用 O(n) 的时间复杂度解决这个问题吗？
 * 链接：https://leetcode-cn.com/problems/largest-bst-subtree
 *
 * @author tuhailong
 * @since 2020-04-30
 */
public class LeetCode0333 {
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = binarySearchTreeNodeCounter(root);
        int lMax = largestBSTSubtree(root.left);
        int rMax = largestBSTSubtree(root.right);
        return Math.max(max, Math.max(lMax, rMax));
    }

    private int binarySearchTreeNodeCounter(TreeNode node) {
        if (node == null) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        inorder(node, list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            if (list.get(i - 1) >= list.get(i)) {
                return -1;
            }
        }
        return size;
    }

    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }
}
