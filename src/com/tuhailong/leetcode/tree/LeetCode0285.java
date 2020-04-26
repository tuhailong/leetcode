package com.tuhailong.leetcode.tree;

import com.tuhailong.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树中的顺序后继
 *
 * 给你一个二叉搜索树和其中的某一个结点，请你找出该结点在树中顺序后继的节点。
 * 结点 p 的后继是值比 p.val 大的结点中键值最小的结点。
 * 示例 1:
 * 输入: root = [2,1,3], p = 1
 * 输出: 2
 * 解析: 这里 1 的顺序后继是 2。请注意 p 和返回值都应是 TreeNode 类型。
 * 示例 2:
 * 输入: root = [5,3,6,2,4,null,null,1], p = 6
 * 输出: null
 * 解析: 因为给出的结点没有顺序后继，所以答案就返回 null 了。
 * 注意:
 * 假如给出的结点在该树中没有顺序后继的话，请返回 null
 * 我们保证树中每个结点的值是唯一的
 *
 * 链接：https://leetcode-cn.com/problems/inorder-successor-in-bst
 *
 * @author tuhailong
 * @since 2020-04-26
 */
public class LeetCode0285 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode node) {
        if (root == null || node == null) {
            return null;
        }
        TreeNode succ = null;
        TreeNode curr = root;
        while (curr != null) {
            if (curr.val <= node.val) {
                curr = curr.right;
            } else {
                succ = curr;
                curr = curr.left;
            }
        }
        return succ;
    }

    public TreeNode inorderSuccessorMyself(TreeNode root, TreeNode node) {
        if (root == null || node == null) {
            return null;
        }
        List<TreeNode> orderedList = new ArrayList<>();
        inorder(root, orderedList);
        int size = orderedList.size();
        for (int i = 1; i < size; i++) {
            if (node == orderedList.get(i - 1)) {
                return orderedList.get(i);
            }
        }
        return null;
    }

    private void inorder(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        inorder(node.left, list);
        list.add(node);
        inorder(node.right, list);
    }
}
