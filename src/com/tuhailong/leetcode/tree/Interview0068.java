package com.tuhailong.leetcode.tree;

import com.tuhailong.leetcode.TreeNode;

/**
 * 二叉树的最近公共祖先
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：
 *  "对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 *  满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）"
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *        3
 *     /    \
 *    5     1
 *  /  \   / \
 * 6   2  0  8
 *    / \
 *   7  4
 * 示例 1:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof
 *
 * @author tuhailong
 * @since 2020-04-25
 */
public class Interview0068 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode pNode, TreeNode qNode) {
        if (root == null || pNode == root || qNode == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, pNode, qNode);
        TreeNode right = lowestCommonAncestor(root.right, pNode, qNode);
        if (left == null && right == null) {
            return null;
        }
        if (left != null && right == null) {
            return left;
        }
        if (left == null && right != null) {
            return right;
        }
        return root;
    }
}
