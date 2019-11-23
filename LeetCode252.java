package com.tuhailong.leetcode;

import java.util.Arrays;

/**
 * 给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间[[s1,e1],[s2,e2],...](si < ei)。
 * 请你判断一个人是否能够参加这里面的全部会议。
 * 示例 1:
 * 输入: [[0,30],[5,10],[15,20]]
 * 输出: false
 * 示例 2:
 * 输入: [[7,10],[2,4]]
 * 输出: true
 * 链接：https://leetcode-cn.com/problems/meeting-rooms
 *
 * @author tuhailong
 * @since 2019-11-19
 */
class LeetCode252 {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        // 以会议的开始时间排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < intervals.length - 1; i++) {
            // 当前会议的结束时间大于下个会议的开始时间，则不能参加全部的会议。
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }
}
