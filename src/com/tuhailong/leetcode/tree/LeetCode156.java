package com.tuhailong.leetcode.tree;

import com.tuhailong.leetcode.TreeNode;

/**
 * 给定一个二叉树，其中所有的右节点要么是具有兄弟节点（拥有相同父节点的左节点）的叶节点，要么为空.
 * 将此二叉树上下翻转并将它变成一棵树， 原来的右节点将转换成左叶节点。
 * 返回新的根。
 * 例子:
 * 输入: [1,2,3,4,5]
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 *
 * 输出: 返回二叉树的根 [4,5,2,#,#,3,1]
 *    4
 *   / \
 *  5   2
 *     / \
 *    3   1
 * 链接：https://leetcode-cn.com/problems/binary-tree-upside-down
 *
 * @author tuhailong
 * @since 2019-11-29
 */
public class LeetCode156 {
    /**
     * 树中任何节点的右子节点若存在一定有左子节点，因此思路是向左遍历树进行转化；
     * 规律：左子节点变父节点；父节点变右子节点；右子节点变父节点。
     * 对于某节点root，修改root.left，root.right之前，需要将三者都存下来：
     *  root.left是下一轮递归的主节点；
     *  root是下一轮递归root的root.right；
     *  root.right是下一轮递归root的root.left。
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode parentNode = null;
        TreeNode parentRight = null;
        while (root != null) {
            TreeNode rootLeft = root.left;
            root.left = parentRight;
            parentRight = root.right;
            root.right = parentNode;
            parentNode = root;
            root = rootLeft;
        }
        return parentNode;
    }
}
