package com.tuhailong.leetcode.tree;

import com.tuhailong.leetcode.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * 假定 BST 有如下定义：
 *  结点左子树中所含结点的值小于等于当前结点的值
 *  结点右子树中所含结点的值大于等于当前结点的值
 *  左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 * 提示：如果众数超过1个，不需考虑输出顺序
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 * 链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
 *
 * @author tuhailong
 * @since 2019-11-27
 */
class LeetCode0501 {

    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        inorder(root, map);
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int cnt = entry.getValue();
            if (max < cnt) {
                list.clear();
                max = cnt;
                list.add(entry.getKey());
            } else if (max == cnt) {
                list.add(entry.getKey());
            } else {
                continue;
            }
        }
        Collections.sort(list);
        int len = list.size();
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    private void inorder(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        inorder(root.left, map);
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        inorder(root.right, map);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = Debuger.stringToTreeNode(line);
            LeetCode0501 ni = new LeetCode0501();
            System.out.print(Arrays.toString(ni.findMode(root)));
        }
    }
}
