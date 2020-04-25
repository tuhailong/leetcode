package com.tuhailong.leetcode.tree;

import com.tuhailong.leetcode.TreeNode;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 *
 * @author tuhailong
 * @since 2019-11-27
 */
public class LeetCode0103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            boolean rtl = (++depth % 2 == 0);
            int n = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (rtl) {
                    list.add(0, node.val);
                } else {
                    list.add(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans.add(list);
        }
        return ans;
    }

    /**
     * 给定一个二叉树，找出其最大深度。
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     * 说明: 叶子节点是指没有子节点的节点。
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回它的最大深度 3 。
     * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
     *
     * @author tuhailong
     * @since 2019-11-14
     */
    static class LeetCode104 {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }

        public int maxDepthViaBFS(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int depth = 0;
            Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
            queue.offer(new Pair<>(root, 1));
            while (!queue.isEmpty()) {
                Pair<TreeNode, Integer> pair = queue.poll();
                TreeNode node = pair.getKey();
                depth = pair.getValue();
                if (node.left != null) {
                    queue.offer(new Pair<>(node.left, depth + 1));
                }
                if (node.right != null) {
                    queue.offer(new Pair<>(node.right, depth + 1));
                }
            }
            return depth;
        }
    }
}
