package com.tuhailong.leetcode.tree;

import com.tuhailong.leetcode.TreeNode;

/**
 * 删除二叉搜索树中的节点
 *
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。
 * 返回二叉搜索树（有可能被更新）的根节点的引用。
 * 一般来说，删除节点可分为两个步骤：首先找到需要删除的节点；如果找到了，删除它。
 * 说明：要求算法时间复杂度为 O(h)，h 为树的高度。
 * 示例:
 * root = [5,3,6,2,4,null,7]
 * key = 3
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 * 给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 *     5
 *    / \
 *   4   6
 *  /     \
 * 2       7
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 *     5
 *    / \
 *   2   6
 *    \   \
 *     4   7
 * 链接：https://leetcode-cn.com/problems/delete-node-in-a-bst
 *
 * @author tuhailong
 * @since 2020-4-25
 */
public class LeetCode0450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (!isTargetPresent(root, key)) {
            return root;
        }
        return delete(root, key);
    }

    private boolean isTargetPresent(TreeNode node, int key) {
        if (node == null) {
            return false;
        }
        if (node.val < key) {
            return isTargetPresent(node.right, key);
        } else if (node.val == key) {
            return true;
        } else {
            return isTargetPresent(node.left, key);
        }
    }

    private TreeNode delete(TreeNode node, int key) {
        if (node == null) {
            return null;
        }
        if (node.val < key) {
            node.right = delete(node.right, key);
        } else if (node.val == key) {
            // 该节点没有任何子树, 则直接删除它
            if (node.left == null && node.right == null) {
                node = null;
            }
            // 该结点没有右子树, 则要找到该结点的前驱结点
            else if (node.left != null && node.right == null) {
                // 使用前驱结点的值替代该结点的值
                node.val = precursor(node).val;
                // 删除前驱结点
                node.left = delete(node.left, node.val);
            }
            // 该结点没有左子树, 则要找到该结点的后继结点
            else if (node.left == null && node.right != null) {
                // 使用后继结点的值替代该结点的值
                node.val = successor(node).val;
                // 删除后继结点
                node.right = deleteNode(node.right, node.val);
            }
            // 该结点既有左子树又有右子树, 找到该结点的后继结点
            else {
                // 使用后继结点的值替代该结点的值
                node.val = successor(node).val;
                // 删除后继结点
                node.right = deleteNode(node.right, node.val);
            }
        } else {
            node.left = delete(node.left, key);
        }
        return node;
    }

    /*
     * successor代表的是中序遍历序列的下一个节点, 即比当前节点大的最小节点,简称后继节点.
     * 先取当前节点的右节点, 然后一直取该节点的左节点, 直到左节点为空, 则最后指向的节点为后继节点.
     */
    private TreeNode successor(TreeNode node) {
        node = node.right;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    /*
     * precursor代表的是中序遍历序列的上一个节点, 即比当前节点小的最大节点,简称前驱节点.
     * 先取当前节点的左节点, 然后一直取该节点的右节点, 直到右节点为空, 则最后指向的节点为前驱节点.
     */
    private TreeNode precursor(TreeNode node) {
        node = node.left;
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
}
