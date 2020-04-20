package com.tuhailong.leetcode;

/**
 * 岛屿的数量
 * <p>
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * 示例 1:
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 * 示例 2:
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 * <p>
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 *
 * @author tuhailong
 * @date 2020-04-21
 */

public class LeetCode200 {
    private static final char NOT_VISITED = '1';
    private static final char HAD_VISITED = '2';

    /**
     * the number of islands
     *
     * @param grid the given array
     * @return the number of islands
     */
    public int numIslands(char[][] grid) {
        int num = 0;
        for (int rid = 0; rid < grid.length; rid++) {
            for (int cid = 0; cid < grid[rid].length; cid++) {
                if (grid[rid][cid] == NOT_VISITED) {
                    num += 1;
                    dfs(grid, rid, cid);
                }
            }
        }
        return num;
    }

    private void dfs(char[][] grid, int rid, int cid) {
        grid[rid][cid] = HAD_VISITED;
        if (rid - 1 >= 0 && grid[rid - 1][cid] == NOT_VISITED) {
            dfs(grid, rid - 1, cid);
        }
        if (rid + 1 < grid.length && grid[rid + 1][cid] == NOT_VISITED) {
            dfs(grid, rid + 1, cid);
        }
        if (cid - 1 >= 0 && grid[rid][cid - 1] == NOT_VISITED) {
            dfs(grid, rid, cid - 1);
        }
        if (cid + 1 < grid[rid].length && grid[rid][cid + 1] == NOT_VISITED) {
            dfs(grid, rid, cid + 1);
        }
    }
}
