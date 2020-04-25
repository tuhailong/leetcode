package com.tuhailong.leetcode.tree;

import com.tuhailong.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * 序列化和反序列化二叉搜索树
 *
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，
 * 或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 * 设计一个算法来序列化和反序列化二叉搜索树。 对序列化/反序列化算法的工作方式没有限制。
 * 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 *
 * 编码的字符串应尽可能紧凑。
 * 注意：不要使用类成员/全局/静态变量来存储状态。
 *      你的序列化和反序列化算法应该是无状态的。
 *
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-bst/
 *
 * @author tuhailong
 * @since 2020-04-25
 */
public class LeetCode0449 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder buffer = new StringBuilder();
        return preorderForSerialize(root, buffer);
    }

    public String preorderForSerialize(TreeNode root, StringBuilder buffer) {
        if (root == null) {
            buffer.append("null").append(",");
        } else {
            buffer.append(root.val).append(",");
            preorderForSerialize(root.left, buffer);
            preorderForSerialize(root.right, buffer);
        }
        return buffer.substring(0, buffer.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] elems = data.split(",");
        Queue<String> queue = new ArrayDeque<>(Arrays.asList(elems));
        return preorderForDeserialize(queue);
    }

    private TreeNode preorderForDeserialize(Queue<String> queue) {
        if ("null".equals(queue.peek())) {
            queue.poll();
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(queue.poll()));
        node.left = preorderForDeserialize(queue);
        node.right = preorderForDeserialize(queue);
        return node;
    }
}
