package com.tuhailong.leetcode.tree;

import com.tuhailong.leetcode.TreeNode;

import java.util.HashMap;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length,
            inorder, 0, inorder.length,
            inorderMap);
    }

    private TreeNode helper(int[] preorder, int preorderLeft, int preorderRight,
            int[] inorder, int inorderLeft, int inorderRight,
            HashMap<Integer, Integer> inorderMap) {
        if (preorderLeft >= preorderRight || inorderLeft >= inorderRight) {
            return null;
        }
        int value = preorder[preorderLeft];
        TreeNode root = new TreeNode(value);
        int index = inorderMap.get(value);
        // 左子树结点数量
        int count = index - inorderLeft;
        root.left = helper(preorder, preorderLeft + 1, preorderLeft + count + 1,
            inorder, inorderLeft, index,
            inorderMap);
        root.right = helper(preorder, preorderLeft + count + 1, preorderRight,
            inorder, index + 1, inorderRight,
            inorderMap);
        return root;
    }
}
