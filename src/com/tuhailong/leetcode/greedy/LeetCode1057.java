package com.tuhailong.leetcode.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * 在由 2D 网格表示的校园里有 n 位工人（worker）和 m 辆自行车（bike），n <= m。
 * 所有工人和自行车的位置都用网格上的 2D 坐标表示。
 * 我们需要为每位工人分配一辆自行车。
 * 在所有可用的自行车和工人中，我们选取彼此之间曼哈顿距离最短的工人自行车对(worker, bike)，并将其中的自行车分配給工人。
 * 如果有多个(worker, bike)对之间的曼哈顿距离相同，那么我们选择工人索引最小的那对。
 * 类似地，如果有多种不同的分配方法，则选择自行车索引最小的一对。
 * 不断重复这一过程，直到所有工人都分配到自行车为止。
 * 给定两点 p1 和 p2 之间的曼哈顿距离为 Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|。
 * 返回长度为 n 的向量 ans，其中 a[i] 是第 i 位工人分配到的自行车的索引（从 0 开始）。
 * 示例 1：
 * 输入：workers = [[0,0],[2,1]], bikes = [[1,2],[3,3]]
 * 输出：[1,0]
 * 解释：
 * 工人 1 分配到自行车 0，因为他们最接近且不存在冲突，工人 0 分配到自行车 1.
 * 所以输出是 [1,0].
 * 示例 2：
 * 输入：workers = [[0,0],[1,1],[2,0]], bikes = [[1,0],[2,2],[2,1]]
 * 输出：[0,2,1]
 * 解释：
 * 工人 0 首先分配到自行车 0;
 * 工人 1 和工人 2 与自行车 2 距离相同，因此工人 1 分配到自行车 2;
 * 工人 2 将分配到自行车 1.
 * 因此输出为 [0,2,1]。
 * 提示：
 * 0 <= workers[i][j], bikes[i][j] < 1000
 * 所有工人和自行车的位置都不相同。
 * 1 <= workers.length <= bikes.length <= 1000
 * 链接：https://leetcode-cn.com/problems/campus-bikes
 */
public class LeetCode1057 {
    private static class Node {
        int distance;
        int workerId;
        int bikeId;

        public Node(int distance, int workerId, int bikeId) {
            this.distance = distance;
            this.workerId = workerId;
            this.bikeId = bikeId;
        }
    }

    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int[] ans = new int[workers.length];
        Arrays.fill(ans, -1);
        boolean[] done = new boolean[bikes.length];
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                int manhattan = Math.abs(workers[i][0] - bikes[j][0])
                        + Math.abs(workers[i][1] - bikes[j][1]);
                list.add(new Node(manhattan, i, j));
            }
        }
        Collections.sort(list, (o1, o2) -> {
            if (o1.distance == o2.distance) {
                if (o1.workerId == o2.workerId) {
                    return o1.bikeId - o2.bikeId;
                }
                return o1.workerId - o2.workerId;
            } else {
                return o1.distance - o2.distance;
            }
        });
        int cnt = 0;
        int len = list.size();
        for (int i = 0; i < len; i++) {
            int bid = list.get(i).bikeId;
            int wid = list.get(i).workerId;
            if (ans[wid] >= 0 || done[bid]) {
                continue;
            }
            ans[wid] = bid;
            done[bid] = true;
            if (++cnt == workers.length) {
                break;
            }
        }
        return ans;
    }

    public int[] assignBikesOpted(int[][] workers, int[][] bikes) {
        int[] ans = new int[workers.length];
        Arrays.fill(ans, -1);
        boolean[] bikeVisited = new boolean[bikes.length];

        ArrayList<int[]>[] buckets = new ArrayList[2001];
        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                int dist = Math.abs(workers[i][0] - bikes[j][0])
                        + Math.abs(workers[i][1] - bikes[j][1]);
                if (buckets[dist] == null) {
                    buckets[dist] = new ArrayList<>();
                }
                buckets[dist].add(new int[]{i, j});
            }
        }

        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] == null)
                continue;
            for (int idx = 0; idx < buckets[i].size(); idx++) {
                int wid = buckets[i].get(idx)[0];
                int bid = buckets[i].get(idx)[1];
                if (ans[wid] >= 0 || bikeVisited[bid])
                    continue;
                ans[wid] = bid;
                bikeVisited[bid] = true;
            }
        }
        return ans;
    }

    public int[] assignBikesViaHash(int[][] workers, int[][] bikes) {
        int[] ans = new int[workers.length];
        Arrays.fill(ans, -1);
        boolean[] bikeVisited = new boolean[bikes.length];
        TreeMap<Integer, ArrayList<int[]>> map = new TreeMap<>();
        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                int distance = Math.abs(workers[i][0] - bikes[j][0])
                        + Math.abs(workers[i][1] - bikes[j][1]);
                ArrayList list = map.getOrDefault(distance, new ArrayList<>());
                list.add(new int[]{i, j});
                map.put(distance, list);

            }
        }
        int cnt = 0;
        for (Map.Entry<Integer, ArrayList<int[]>> entry : map.entrySet()) {
            ArrayList<int[]> list = entry.getValue();
            int len = list.size();
            for (int i = 0; i < len; i++) {
                int wid = list.get(i)[0];
                int bid = list.get(i)[1];
                if (ans[wid] >= 0 || bikeVisited[bid]) {
                    continue;
                }
                ans[wid] = bid;
                bikeVisited[bid] = true;
                if (++cnt == workers.length) {
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1057 ni = new LeetCode1057();
        //int[][] workers = {{240, 446}, {745, 948}, {345, 136}, {341, 68}, {990, 165}, {165, 580}, {133, 454}, {113, 527}};
        //int[][] bikes = {{696, 140}, {95, 393}, {935, 185}, {767, 205}, {387, 767}, {214, 960}, {804, 710}, {956, 307}};
        int[][] bikes = {{1, 0}, {2, 2}, {2, 1}};
        int[][] workers = {{0, 0}, {1, 1}, {2, 0}};
        int[] ans = ni.assignBikes(workers, bikes);
        System.out.println(Arrays.toString(ans));
    }
}
