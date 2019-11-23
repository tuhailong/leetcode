package com.tuhailong.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间[[s1,e1],[s2,e2],...](si < ei)。
 * 为避免会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。
 * 示例 1:
 * 输入: [[0, 30],[5, 10],[15, 20]]
 * 输出: 2
 * 示例 2:
 * 输入: [[7,10],[2,4]]
 * 输出: 1
 * 链接：https://leetcode-cn.com/problems/meeting-rooms-ii
 *
 * @author tuhailong
 * @since 2019-11-19
 */
class LeetCode253 {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<Integer> queue = new PriorityQueue<>(intervals.length);
        queue.offer(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (queue.peek() < intervals[i][0]) {
                queue.poll();
            }
            queue.offer(intervals[i][1]);
        }
        return queue.size();
    }
}
