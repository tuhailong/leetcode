package com.tuhailong.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 给你一个不同学生的分数列表，请按 学生的 id 顺序 返回每个学生 最高的五科 成绩的 平均分。
 * 对于每条 items[i] 记录， items[i][0] 为学生的 id，items[i][1] 为学生的分数。平均分请采用整数除法计算。
 * 示例：
 * 输入：[[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
 * 输出：[[1,87],[2,88]]
 * 解释：
 * id = 1 的学生平均分为 87。
 * id = 2 的学生平均分为 88.6。但由于整数除法的缘故，平均分会被转换为 88。
 * 提示：
 * 1 <= items.length <= 1000
 * items[i].length == 2
 * 学生的 ID 在 1 到 1000 之间
 * 学生的分数在 1 到 100 之间
 * 每个学生至少有五个分数
 * 链接：https://leetcode-cn.com/problems/high-five
 */
public class LeetCode1086 {
    public int[][] highFive(int[][] items) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i = 0; i < items.length; i++) {
            PriorityQueue<Integer> heap = map.getOrDefault(items[i][0], new PriorityQueue<>((o1, o2) -> o1 - o2));
            heap.offer(items[i][1]);
            if (heap.size() > 5) {
                heap.poll();
            }
            map.put(items[i][0], heap);
        }
        ArrayList<int[]> list = new ArrayList<>();
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            int id = entry.getKey();
            int av = (int) entry.getValue().stream().mapToInt((x) -> x).summaryStatistics().getAverage();
            list.add(new int[]{id, av});
        }
        Collections.sort(list, (o1, o2) -> o1[0] - o2[0]);
        return list.toArray(new int[0][]);
    }
}
