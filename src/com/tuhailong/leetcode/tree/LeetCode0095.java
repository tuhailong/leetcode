package com.tuhailong.leetcode.tree;

import com.tuhailong.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 * 示例:
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
 *
 * @author tuhailong
 * @since 2019-11-27
 */
class LeetCode0095 {
    /**
     * 算法思路：递归
     *  1.从序列1 ..n中取出数字i，作为当前树的树根
     *  2.对[1, i-1]构造所有可能的左子树
     *  3.对[i+1, n]构造所有可能的右子树
     *  4.以i为root结点连接所有可能的左右子树
     *  5.重复以上过程
     */
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans = new ArrayList<>();
        if (n == 0) {
            return ans;
        }
        return helper(1, n);
    }

    private ArrayList<TreeNode> helper(int start, int end) {
        ArrayList<TreeNode> trees = new ArrayList<>();
        if (start > end) {
            trees.add(null);
            return trees;
        }
        // 选择i为root结点
        for (int i = start; i <= end; i++) {
            // start到i-1构建左子树
            ArrayList<TreeNode> leftTrees = helper(start, i - 1);
            // i+1到end构建右子树
            ArrayList<TreeNode> rightTrees = helper(i + 1, end);
            // 以i为root结点连接所有可能的左右子树
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode tree = new TreeNode(i);
                    tree.left = leftTree;
                    tree.right = rightTree;
                    trees.add(tree);
                }
            }
        }
        return trees;
    }
}
