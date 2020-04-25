package com.tuhailong.leetcode.tree;

import com.tuhailong.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前序遍历
 *
 * 给定一个二叉树，返回它的 前序 遍历。
 * 示例:
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 * 输出: [1,2,3]
 *
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 *
 * @author tuhailong
 * @since 2020-04-22
 */
public class LeetCode0144 {

    public List<Integer> preorderTraversalViaIteration(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            // 1. 首先访问根结点
            list.add(node.val);
            // 3. 最后遍历右子树: 先进后出
            if (node.right != null) {
                stack.push(node.right);
            }
            // 2. 然后遍历左子树: 后进先出
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return list;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(list, root);
        return list;
    }

    private void preorder(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }
        // 1.首先访问根节点
        list.add(node.val);
        // 2.然后遍历左子树
        preorder(list, node.left);
        // 3.最后遍历右子树
        preorder(list, node.right);
    }
 }
