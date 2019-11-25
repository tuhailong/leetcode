package com.tuhailong.leetcode.greedy;

import java.util.PriorityQueue;

/**
 * 为了装修新房，你需要加工一些长度为正整数的棒材 sticks。
 * 如果要将长度分别为 X 和 Y 的两根棒材连接在一起，你需要支付 X + Y 的费用。
 * 由于施工需要，你必须将所有棒材连接成一根。
 * 返回你把所有棒材 sticks 连成一根所需要的最低费用。注意你可以任意选择棒材连接的顺序。
 * 示例 1：
 * 输入：sticks = [2,4,3]
 * 输出：14
 * 解释：先将 2 和 3 连接成 5，花费 5；再将 5 和 4 连接成 9；总花费为 14。
 * 示例 2：
 * 输入：sticks = [1,8,3,5]
 * 输出：30
 * 提示：
 * 1 <= sticks.length <= 10^4
 * 1 <= sticks[i] <= 10^4
 * 链接：https://leetcode-cn.com/problems/minimum-cost-to-connect-sticks
 *
 * @author tuhailong
 * @since 2019-10-25
 */
public class LeetCode1167 {
    /**
     * 解题思路：贪心算法
     * 将所有值都加入到优先队列（小顶堆）中，每次从优先队列中取出两个最小数相加，然后将相加的值再加入到优先队列中；
     * 不断重复这个过程，直到优先队列只剩下一个元素为止。
     * 这样产生的费用就是最小费用。
     * 实质上是贪心算法，利用了优先队列来获取最新的最小的两个值。
     */
    public int connectSticks(int[] sticks) {
        if (sticks == null || sticks.length <= 1) {
            return 0;
        }
        int ans = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int stick : sticks) {
            heap.offer(stick);
        }
        while (!heap.isEmpty()) {
            int i = heap.poll();
            if (heap.isEmpty()) {
                break;
            }
            int j = heap.poll();
            ans += (i + j);
            heap.offer(i + j);
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1167 ni = new LeetCode1167();
        int[] sticks = {3354, 4316, 3259, 4904, 4598, 474, 3166, 6322, 8080, 9009};
        System.out.println(ni.connectSticks(sticks));
    }
}
