package com.tuhailong.leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个 N 叉树，找到其最大深度。
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * 例如，给定一个3叉树:
 * 我们应返回其最大深度，3。
 *       1
 *     / | \
 *    3  2  4
 *   / \
 *  5   6
 * 说明:
 * 树的深度不会超过 1000。
 * 树的节点总不会超过 5000。
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree
 *
 * @author tuhailong
 * @since 2019-11-27
 */
public class LeetCode0559 {
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int cnt;
        while ((cnt = queue.size()) > 0) {
            ++depth;
            for (int i = 0; i < cnt; i++) {
                Node node = queue.poll();
                List<Node> subNodes = node.children;
                if (subNodes == null) {
                    continue;
                }
                for (Node subNode : subNodes) {
                    if (subNode == null) {
                        continue;
                    }
                    queue.offer(subNode);
                }
            }
        }
        return depth;
    }
}
