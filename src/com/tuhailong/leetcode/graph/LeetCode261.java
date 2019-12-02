package com.tuhailong.leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定从 0 到 n-1 标号的 n 个结点，和一个无向边列表（每条边以结点对来表示），
 * 请编写一个函数用来判断这些边是否能够形成一个合法有效的树结构。
 * 示例 1：
 * 输入: n = 5, 边列表 edges = [[0,1], [0,2], [0,3], [1,4]]
 * 输出: true
 * 示例 2:
 * 输入: n = 5, 边列表 edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
 * 输出: false
 * 注意：你可以假定边列表edges中不会出现重复的边。由于所有的边是无向边，
 * 边[0,1]和边[1,0]是相同的，因此不会同时出现在边列表 edges 中。
 * 链接：https://leetcode-cn.com/problems/graph-valid-tree
 *
 * @author tuhailong
 * @since 2019-12-02
 */
public class LeetCode261 {
    /**
     * 解题思路：若图中无环且连通分量为1，则为树
     */
    public boolean validTree(int n, int[][] edges) {
        if (edges.length + 1 != n) {
            return false;
        }
        int[][] graph = new int[n][n];
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            Integer v1 = queue.poll();
            visited[v1] = true;
            for (int v2 = 0; v2 < n; v2++) {
                if (graph[v1][v2] == 0) {
                    continue;
                }
                // 存在环
                if (visited[v2]) {
                    return false;
                }
                visited[v2] = true;
                graph[v1][v2] = 0;
                graph[v2][v1] = 0;
                queue.offer(v2);
            }
        }
        // 判断是否单恋通
        for (int v = 0; v < n; v++) {
            if (!visited[v]) {
                return false;
            }
        }
        return true;
    }
}
