package com.tuhailong.leetcode.tree;

import com.tuhailong.leetcode.TreeNode;

import java.util.HashMap;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 *
 * @author tuhailong
 * @since 2019-11-27
 */
public class LeetCode0105 {
    private int mPreIdx;
    private int[] mInorders;
    private int[] mPreorders;
    private HashMap<Integer, Integer> mMap = new HashMap<>();


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        if (preorder.length != inorder.length) {
            return null;
        }
        this.mPreIdx = 0;
        this.mInorders = inorder;
        this.mPreorders = preorder;
        // 构建中序遍历数组的value-index键值对
        for (int i = 0; i < mInorders.length; i++) {
            mMap.put(mInorders[i], i);
        }

        return builder(0, mInorders.length - 1);
    }

    private TreeNode builder(int inLid, int inRid) {
        // 若inLid > inRid，则说明是空树
        if (inLid > inRid) {
            return null;
        }
        // 从先序遍历数组中获取根节点的值
        int preValue = mPreorders[mPreIdx];
        // 根据根节点的值，构建当前的根节点
        TreeNode node = new TreeNode(preValue);
        // 根基根节点的值，获取中序遍历数组中的index
        int index = mMap.get(preValue);
        /***********************************************************************************
         根节点在中序遍历中索引为index, 则从inLid到index-1属于左子树, 从index+1到inRid属于右子树.
         根据先序遍历逻辑, 递归创建左子树builder(inLid, index - 1)和右子树builder(index + 1, inRid).
         注意: 一定要先建左子树, 因为mPreIdx在先序遍历数组往后移动(mPreIdx)的时候, 先指向左子树的结点.
         ***********************************************************************************/
        mPreIdx++;
        node.left = builder(inLid, index - 1);
        node.right = builder(index + 1, inRid);
        return node;
    }
}
