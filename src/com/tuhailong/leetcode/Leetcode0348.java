package com.tuhailong.leetcode;

public class Leetcode0348 {
    class TicTacToe {
        private final int[][] mGrid;
        public TicTacToe(int n) {
            mGrid = new int[n][n];
        }
        public int move(int row, int col, int player) {
            mGrid[row][col] = player;
            int num = mGrid.length;
            for (int idx = 0; idx < num; idx++) {
                if (mGrid[idx][col] != player)
                    break;
                if (idx == num - 1) {
                    return player;
                }
            }
            for (int idx = 0; idx < num; idx++) {
                if (mGrid[row][idx] != player)
                    break;
                if (idx == num - 1) {
                    return player;
                }
            }
            if (row == col)
                for (int idx = 0; idx < num; idx++) {
                    if (mGrid[idx][idx] != player)
                        break;
                    if (idx == num - 1)
                        return player;
                }
            if (row + col == num - 1)
                for (int idx = 0; idx < num; idx++) {
                    if (mGrid[idx][num - idx - 1] != player)
                        break;
                    if (idx == num - 1)
                        return player;
                }
            return 0;
        }
    }
}
