package com.tuhailong.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的数值。
 * 注意：
 * 给定的目标值 target 是一个浮点数
 * 题目保证在该二叉搜索树中只会存在一个最接近目标值的数
 * 示例：
 * 输入: root = [4,2,5,1,3]，目标值 target = 3.714286
 *     4
 *    / \
 *   2   5
 *  / \
 * 1   3
 * 输出: 4
 * 链接：https://leetcode-cn.com/problems/closest-binary-search-tree-value
 *
 * @author tuhailong
 * @since 2019-11-19
 */
class LeetCode270 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 广度优先搜索
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            throw new IllegalArgumentException("tree must not empty");
        }
        double min = Double.MAX_VALUE;
        int ans = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            double diff = Math.abs(target - root.val);
            if (min > diff) {
                min = diff;
                ans = root.val;
            }
            if (root.left != null) {
                queue.offer(root.left);
            }
            if (root.right != null) {
                queue.offer(root.right);
            }
        }
        return ans;
    }

    // 深度优先搜索
    public int closestValueBFS(TreeNode root, double target) {
        if (root == null) {
            throw new IllegalArgumentException("tree must not empty");
        }
        double min = Double.MAX_VALUE;
        int ans = Integer.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            if (node == null) {
                continue;
            }
            double diff = Math.abs(node.val - target);
            if (min > diff) {
                min = diff;
                ans = node.val;
            }
            // 下个出栈的结点的值肯定比当前结点的值大
            if (node.val > target) {
                break;
            }
            root = node.right;
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(5);
        LeetCode270 ni = new LeetCode270();
        int ans = ni.closestValueBFS(root, 3.714286);
        System.out.println(ans);
    }
}
