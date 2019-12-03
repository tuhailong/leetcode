package com.tuhailong.leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 验证原始的序列 org 是否可以从序列集 seqs 中唯一地重建。
 * 序列 org 是 1 到 n 整数的排列，其中 1 ≤ n ≤ 104。
 * 重建是指在序列集seqs中构建最短的公共超序列,（即使得所有seqs中的序列都是该最短序列的子序列）。
 * 确定是否只可以从seqs重建唯一的序列，且该序列就是org 。
 * 示例 1：
 * 输入：
 * org: [1,2,3], seqs: [[1,2],[1,3]]
 * 输出：
 * false
 * 解释：
 * [1,2,3] 不是可以被重建的唯一的序列，因为 [1,3,2] 也是一个合法的序列。
 * 示例 2：
 * 输入：
 * org: [1,2,3], seqs: [[1,2]]
 * 输出：
 * false
 * 解释：
 * 可以重建的序列只有 [1,2]。
 * 示例 3：
 * 输入：
 * org: [1,2,3], seqs: [[1,2],[1,3],[2,3]]
 * 输出：
 * true
 * 解释：
 * 序列 [1,2], [1,3] 和 [2,3] 可以被唯一地重建为原始的序列 [1,2,3]。
 * 示例 4：
 * 输入：
 * org: [4,1,5,2,6,3], seqs: [[5,2,6,3],[4,1,5,2]]
 * 输出：
 * true
 * 链接：https://leetcode-cn.com/problems/sequence-reconstruction
 *
 * @author tuhailong
 * @since 2019-12-03
 */
public class LeetCode444 {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if (seqs.isEmpty()) {
            return false;
        }
        int len = org.length;
        // seq里的所有数，是否都是1~n的
        Set<Integer> set = new HashSet<>();
        for (List<Integer> seq : seqs) {
            for (Integer num : seq) {
                set.add(num);
            }
        }
        if (set.size() != len) {
            return false;
        }
        // 构建邻接表
        ArrayList<Integer>[] adj = new ArrayList[len + 1];
        for (int i = 1; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
        for (List<Integer> seq : seqs) {
            int cnt = seq.size();
            for (int i = 0; i < cnt - 1; i++) {
                adj[seq.get(i)].add(seq.get(i + 1));
            }
        }
        // 计算所有结点的入度
        int[] indegrees = new int[len + 1];
        for (int i = 1; i < adj.length; i++) {
            int cnt = adj[i].size();
            for (int j = 0; j < cnt; j++) {
                indegrees[adj[i].get(j)]++;
            }
        }
        // 入度为0的节点
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        if (queue.size() != 1) {
            return false;
        }
        // 拓扑排序
        int idx = 0;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            if (org[idx] != num) {
                return false;
            }
            idx++;
            // 删除当前节点后，所有当前节点的下一个节点的入度为0的个数，超过1则说明序列不唯一
            int nextZeroInDegreeCount = 0;
            for (Integer vertex : adj[num]) {
                if (--indegrees[vertex] == 0) {
                    if (++nextZeroInDegreeCount > 1) {
                        return false;
                    }
                    queue.offer(vertex);
                }
            }
        }
        return idx == len;
    }
}
