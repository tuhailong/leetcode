package com.tuhailong.leetcode.tree;

import com.tuhailong.leetcode.TreeNode;

import java.util.HashMap;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 *
 * @author tuhailong
 * @since 2019-11-28
 */
class LeetCode0106 {
    private int mPostIdx;
    private int[] mInorders;
    private int[] mPostorders;
    private HashMap<Integer, Integer> mMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) {
            return null;
        }
        if (inorder.length != postorder.length) {
            return null;
        }
        this.mInorders = inorder;
        this.mPostorders = postorder;
        this.mPostIdx = postorder.length - 1;
        // 构建中序遍历数组的value-index键值对
        for (int idx = 0; idx < mInorders.length; idx++) {
            mMap.put(mInorders[idx], idx);
        }
        return builder(0, mInorders.length - 1);
    }

    private TreeNode builder(int inLid, int inRid) {
        // 若inLid > inRid，则说明是空树
        if (inLid > inRid) {
            return null;
        }
        // 从后序遍历数组中获取根节点的值
        int postValue = mPostorders[mPostIdx];
        // 根据根节点的值，构建新的根节点
        TreeNode node = new TreeNode(postValue);
        // 根据根节点的值，获取中序遍历数组中的index
        int index = mMap.get(postValue);
        /***********************************************************************************
         根节点在中序遍历中索引为index, 则从inLid到index-1属于左子树, 从index+1到inRid属于右子树.
         根据后序遍历逻辑, 递归创建右子树builder(index + 1, inRid)和左子树builder(inLid, index - 1).
         注意: 一定要先建右子树, 因为mPostIdx在后序遍历数组往前移动(mPostIdx--)的时候, 先指向右子树的结点.
         ***********************************************************************************/
        mPostIdx--;
        node.right = builder(index + 1, inRid);
        node.left = builder(inLid, index - 1);
        return node;
    }
}
