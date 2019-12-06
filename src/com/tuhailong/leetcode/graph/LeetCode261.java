package com.tuhailong.leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
    //  BFS
    public boolean validTree(int n, int[][] edges) {
        if (edges.length + 1 != n) {
            return false;
        }
        // 构建邻接矩阵
        int[][] graph = new int[n][n];
        // 存在边的设置为1; 否则, 默认为0
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        // 从第一个节点开始搜索， 不会漏掉无边图
        queue.offer(0);
        while (!queue.isEmpty()) {
            Integer v1 = queue.poll();
            visited[v1] = true;
            // 获取邻接边
            for (int v2 = 0; v2 < n; v2++) {
                if (graph[v1][v2] == 0) {
                    continue;
                }
                // 邻接节点已被访问过，则为图存在环，不可能为树结构
                if (visited[v2]) {
                    return false;
                }
                // 标记邻接点已被访问
                visited[v2] = true;
                // 涂黑已访问过的边
                graph[v1][v2] = 0;
                graph[v2][v1] = 0;
                // 将邻接点入队列
                queue.offer(v2);
            }
        }
        // 判断是否是单连通分量
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    //  DFS
    public boolean validTreeViaDFS(int n, int[][] edges) {
        if (edges.length + 1 != n) {
            return false;
        }
        // 构建邻接矩阵
        int[][] graph = new int[n][n];
        // 存在边的设置为1; 否则, 默认为0
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while (!stack.isEmpty()) {
            Integer v1 = stack.pop();
            visited[v1] = true;
            for (int v2 = 0; v2 < n; v2++) {
                if (graph[v1][v2] == 0) {
                    continue;
                }
                if (visited[v2]) {
                    return false;
                }
                visited[v2] = true;
                graph[v1][v2] = 0;
                graph[v2][v1] = 0;
                stack.push(v2);
            }
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
}
