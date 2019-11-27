package com.tuhailong.leetcode.tree;

import com.tuhailong.leetcode.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 *  节点的左子树只包含小于当前节点的数。
 *  节点的右子树只包含大于当前节点的数。
 *  所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为5，但是其右子节点值为4。
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 *
 * @author tuhailong
 * @since 2019-11-27
 */
class LeetCode98 {
    // 递归实现
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }
        if (lower != null && node.val <= lower) {
            return false;
        }
        if (upper != null && node.val >= upper) {
            return false;
        }
        return isValid(node.left, lower, Integer.valueOf(node.val))
            && isValid(node.right, Integer.valueOf(node.val), upper);
    }

    // 迭代实现
    public boolean isValidBSTViaIteration(TreeNode root) {
        if (root == null) {
            return true;
        }
        Integer lower = null;
        Integer upper = null;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> lowers = new Stack<>();
        Stack<Integer> uppers = new Stack<>();
        update(root, lower, upper, stack, lowers, uppers);
        while (!stack.isEmpty()) {
            root = stack.pop();
            lower = lowers.pop();
            upper = uppers.pop();
            if (root == null) {
                continue;
            }
            Integer value = Integer.valueOf(root.val);
            if (lower != null && value <= lower) {
                return false;
            }
            if (upper != null && value >= upper) {
                return false;
            }
            update(root.right, value, upper, stack, lowers, uppers);
            update(root.left, lower, value, stack, lowers, uppers);
        }
        return true;
    }

    private void update(TreeNode node, Integer lower, Integer upper,
        Stack<TreeNode> stack, Stack<Integer> lowers, Stack<Integer> uppers) {
        stack.push(node);
        lowers.push(lower);
        uppers.push(upper);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = Debuger.stringToTreeNode(line);
            boolean ret = new LeetCode98().isValidBST(root);
            String out = Debuger.booleanToString(ret);
            System.out.print(out);
        }
    }
}
