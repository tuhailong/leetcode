package com.tuhailong.leetcode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 *
 * @author tuhailong
 * @since 2019-11-14
 */
class LeetCode110 {
    public boolean isBalanced(TreeNode root) {
        return checkBalance(root) >= 0;
    }

    private int checkBalance(TreeNode root) {
        // root为空表示到底叶子节点，叶子节点的高度为0
        if (root == null) {
            return 0;
        }
        // 检查左子树的高度
        int lret = checkBalance(root.left);
        if (lret < 0) {
            return lret;
        }
        // 检查右子树的高度
        int rret = checkBalance(root.right);
        if (rret < 0) {
            return rret;
        }
        if (Math.abs(lret - rret) < 2) {
            return Math.max(lret, rret) + 1;
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode rootLeft = new TreeNode(9);
        TreeNode rootRight = new TreeNode(20);
        root.left = rootLeft;
        root.right = rootRight;
        rootRight.left = new TreeNode(15);
        rootRight.right = new TreeNode(7);

        LeetCode110 ni = new LeetCode110();
        boolean ans = ni.isBalanced(root);
        System.out.println(ans);
    }
}
