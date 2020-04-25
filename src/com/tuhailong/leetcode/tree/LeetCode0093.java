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
public class LeetCode0093 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            // 1.首先遍历左子树
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 2.然后访问根节点
            TreeNode node = stack.pop();
            ans.add(node.val);
            // 3.最后遍历右子树
            root = node.right;
        }
        return ans;
    }

    public List<Integer> inorderTraversalViaRecursion(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursion(root, list);
        return list;
    }

    private void recursion(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        // 1.首先遍历左子树
        recursion(root.left, ans);
        // 2.然后访问根节点
        ans.add(root.val);
        // 3.最后遍历右子树
        recursion(root.right, ans);
    }
}
