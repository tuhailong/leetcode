package com.tuhailong.leetcode.tree;

import com.tuhailong.leetcode.TreeNode;
import sun.dc.pr.PRError;

import java.util.Stack;

/**
 * 给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。
 * 示例 :
 * 输入:
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出:
 * 1
 * 解释:
 * 最小绝对差为1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 * 注意: 树中至少有2个节点。
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
 *
 * @author tuhailong
 * @since 2019-12-11
 */
public class LeetCode0530 {

    private int mMin = Integer.MAX_VALUE;
    private TreeNode mPreNode = null;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return mMin;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        if (mPreNode != null) {
            mMin = Math.min(Math.abs(mPreNode.val - node.val), mMin);
        }
        mPreNode = node;
        inorder(node.right);
    }

    public int getMinimumDifferenceMine(TreeNode root) {
        int ans = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        int last = Integer.MAX_VALUE;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            ans = Math.min(Math.abs(last - root.val), ans);
            last = root.val;
            root = root.right;
        }
        return ans;
    }
}
