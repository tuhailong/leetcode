package com.tuhailong.leetcode.tree;

import com.tuhailong.leetcode.TreeNode;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 *
 * @author tuhailong
 * @since 2019-11-27
 */
public class LeetCode105 {
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        return helper(preOrder, inOrder, 0, 0, inOrder.length);
    }

    private TreeNode helper(int[] preOrder, int[] inOrder,
                            int preStart, int inStart, int length) {
        if (length == 0) {
            return null;
        }
        int root = preOrder[preStart];
        TreeNode treeNode = new TreeNode(root);
        if (length == 1) {
            return treeNode;
        }
        for (int i = length - 1; i >= 0; i--) {
            if (root == inOrder[inStart + i]) {
                treeNode.left = helper(preOrder, inOrder,
                        preStart + 1, inStart, i);
                treeNode.right = helper(preOrder, inOrder,
                        preStart + 1 + i, inStart + i + 1, length - i - 1);
                return treeNode;
            }
        }
        return null;
    }
}
