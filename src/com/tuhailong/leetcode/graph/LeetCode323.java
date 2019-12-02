package com.tuhailong.leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定编号从 0 到 n-1 的 n 个节点和一个无向边列表（每条边都是一对节点），
 * 请编写一个函数来计算无向图中连通分量的数目。
 * 示例 1:
 * 输入: n = 5 和 edges = [[0, 1], [1, 2], [3, 4]]
 *      0          3
 *      |          |
 *      1 --- 2    4
 *
 * 输出: 2
 * 示例 2:
 * 输入: n = 5 和 edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
 *
 *      0           4
 *      |           |
 *      1 --- 2 --- 3
 * 输出:  1
 * 注意:
 * 你可以假设在 edges 中不会出现重复的边。
 * 而且由于所以的边都是无向边，[0, 1]与[1, 0]相同，所以它们不会同时在edges中出现。
 * 链接：https://leetcode-cn.com/problems/number-of-connected-components-in-an-undirected-graph
 *
 * @author tuhailong
 * @since 2019-12-02
 */
public class LeetCode323 {
    public int countComponents(int n, int[][] edges) {
        int[][] graph = new int[n][n];
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            ++cnt;
            visited[i] = true;
            queue.offer(i);
            while (!queue.isEmpty()) {
                Integer v1 = queue.poll();
                visited[v1] = true;
                for (int v2 = 0; v2 < n; v2++) {
                    if (graph[v1][v2] == 0) {
                        continue;
                    }
                    visited[v2] = true;
                    graph[v1][v2] = 0;
                    graph[v2][v1] = 0;
                    queue.offer(v2);
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        LeetCode323 ni = new LeetCode323();
        System.out.println(ni.countComponents(5, edges));
    }
}
