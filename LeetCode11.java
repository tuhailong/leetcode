package com.tuhailong.leetcode;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且n的值至少为 2。
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。
 * 在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 示例:
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 *
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 *
 * @author tuhailong
 * @since 2019-10-30
 */
class LeetCode11 {
    public int maxArea(int[] height) {
        int max = 0;
        int lid = 0;
        int rid = height.length - 1;
        while (lid < rid) {
            max = Math.max(Math.min(height[rid], height[lid]) * (rid - lid), max);
            if (height[lid] < height[rid]) {
                lid++;
            } else {
                rid--;
            }
        }
        return max;
    }

    public int maxAreaBF(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = height.length - 1; j > i + 1; j--) {
                int area = (height[i] < height[j] ? height[i] : height[j]) * (j - i);
                if (area > max) {
                    max = area;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode11().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
