package com.tuhailong.leetcode;

/**
 * 岛屿的最大面积
 *
 * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
 * 一个岛屿是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。
 * 你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0)
 * 示例 1:
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
 * 示例 2:
 * [[0,0,0,0,0,0,0,0]]
 * 对于上面这个给定的矩阵, 返回 0。
 * 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
 *
 * 链接：https://leetcode-cn.com/problems/max-area-of-island
 *
 * @author tuhailong
 * @since 2020-04-20
 */
public class LeetCode695 {
    private static final int ISLAND_NOT_VISITED = 1;
    private static final int ISLAND_HAS_VISITED = 2;

    /**
     * The max area of the island
     *
     * @param grid the given array
     * @return the max area of the island
     */
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int rid = 0; rid < grid.length; rid++) {
            for (int cid = 0; cid < grid[rid].length; cid++) {
                int area = area(grid, rid, cid);
                ans = Math.max(ans, area);
            }
        }
        return ans;
    }

    /**
     * 网格搜索的搜索的标准DFS写法
     */
    private int area(int[][] grid, int rid, int cid) {
        /** 1.判定当前结点坐标是否合法(rid和cid分别行坐标和列坐标) **/
        if (!isValid(grid, rid, cid)) {
            return 0;
        }
        /** 2.判定当前结点是否已经被访问过
         * 访问标记：
         *  0 表示不可访问区域
         *  1 表示未访问区域
         *  2 表示已访问区域
        **/
        if (grid[rid][cid] != ISLAND_NOT_VISITED) {
            return 0;
        }
        /** 3.标记当前结点坐标为已访问区域 **/
        grid[rid][cid] = ISLAND_HAS_VISITED;
        /** 4.递归调用DFS方法 **/
        return area(grid, rid - 1, cid)
                + area(grid, rid + 1, cid)
                + area(grid, rid, cid - 1)
                + area(grid, rid, cid + 1)
                + 1;
    }

    /** 当前结点坐标是否合法 **/
    private boolean isValid(int[][] grid, int rid, int cid) {
        return (0 <= rid && rid < grid.length)
                && (0 <= cid && cid < grid[0].length);
    }
}
