package com.tuhailong.leetcode.tree;

import com.tuhailong.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 * 示例:
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 *
 * @author tuhailong
 * @since 2019-11-27
 */
public class LeetCode93 {
    // 迭代实现中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            ans.add(node.val);
            root = node.right;
        }
        return ans;
    }

    // 递归实现中序遍历
    public List<Integer> inorderTraversalViaRecursion(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        recursion(root, ans);
        return ans;
    }

    private void recursion(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        recursion(root.left, ans);
        ans.add(root.val);
        recursion(root.right, ans);
    }
}
