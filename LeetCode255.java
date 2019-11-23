package com.tuhailong.leetcode;

import java.util.Stack;

/**
 * 给定一个整数数组，你需要验证它是否是一个二叉搜索树正确的先序遍历序列。
 * 你可以假定该序列中的数都是不相同的。
 * 参考以下这颗二叉搜索树：
 * 5
 * / \
 * 2   6
 * / \
 * 1   3
 * 示例 1：
 * 输入: [5,2,6,1,3]
 * 输出: false
 * 示例 2：
 * 输入: [5,2,1,3,6]
 * 输出: true
 * 进阶挑战：
 * 您能否使用恒定的空间复杂度来完成此题？
 * 链接：https://leetcode-cn.com/problems/verify-preorder-sequence-in-binary-search-tree
 *
 * @author t00278867
 * @since 2019-11-23
 */
class LeetCode255 {
    /**
     * 二叉搜索树：左子树小于root，右子树大于root
     * 解题思想：
     * 先序遍历，如果递减，一定是左子树；
     * 如果出现非递减的值，意味着到了某个节点的右子树；
     * 利用严格递增栈来寻找该节点，最后一个比当前元素小的从栈弹出的元素即为该节点的父亲节点，而且当前元素父节点即为新的下限值；
     * 后续的元素一定是比当前的下限值要大的，否则return false；
     */
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MIN_VALUE;
        for (int num : preorder) {
            if (num < min) {
                return false;
            }
            while (!stack.isEmpty() && num > stack.peek()) {
                min = stack.pop();
            }
            stack.push(num);
        }
        return true;
    }

    public boolean verifyPreorderOpted(int[] preorder) {
        int index = -1;
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < preorder.length; i++) {
            if (preorder[i] < min) {
                return false;
            }
            while (index >= 0 && preorder[i] > preorder[index]) {
                min = preorder[index--];
            }
            preorder[++index] = preorder[i];
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode255 ni = new LeetCode255();
        ni.verifyPreorder(new int[] {5, 2, 1, 3, 6});
    }
}
