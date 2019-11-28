package com.tuhailong.leetcode.tree;

import com.tuhailong.leetcode.TreeNode;

import java.util.HashMap;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 *
 * @author tuhailong
 * @since 2019-11-28
 */
class LeetCode106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return helper(inorder, 0, inorder.length - 1,
            postorder, 0, postorder.length - 1,
            inorderMap);
    }

    public TreeNode helper(int[] inorder, int inorderLeft, int inorderRight,
        int[] postorder, int postorderLeft, int postorderRight,
        HashMap<Integer, Integer> inorderMap) {
        if (inorderLeft > inorderRight || postorderLeft > postorderRight) {
            return null;
        }
        int value = postorder[postorderRight];
        int index = inorderMap.get(value);
        TreeNode root = new TreeNode(value);
        root.left = helper(inorder, inorderLeft, index - 1,
            postorder, postorderLeft, postorderLeft + index - inorderLeft - 1,
            inorderMap);
        root.right = helper(inorder, index + 1, inorderRight,
            postorder, postorderRight  + index - inorderRight, postorderRight - 1,
            inorderMap);
        return root;
    }
}
