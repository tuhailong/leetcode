package com.tuhailong.leetcode.array;

/**
 * 划分为k个相等的子集
 *
 * 给定一个整数数组 nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 * 示例 1：
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 * 注意:
 * 1 <= k <= len(nums) <= 16
 * 0 < nums[i] < 10000
 *
 * 链接：https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets
 *
 * @author tuhailong
 * @since 2020-04-28
 */
public class LeetCode0698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return false;
        }
        // 求数组中所有元素之和
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 若数组中所有元素之和不能被k整除，说明无法被分为k个元素之和相等的子堆
        if (sum % k != 0) {
            return false;
        }
        // 求子堆中所有元素之和
        sum = sum / k;
        // 标记数组中的元素是否已被分到子堆
        boolean[] visited = new boolean[nums.length];
        // 深度优先搜索
        return dfs(nums, k, sum, 0, 0, visited);
    }

    private boolean dfs(int[] nums, int k, int subSum, int startIdx, int currentSum, boolean[] visited) {
        // k为0，则说明所有元素已被分配到和相等的子堆中
        if (k == 0) {
            return true;
        }
        // currentSum与subSum相等，则说明当前第k个子堆已被分配满所有元素之和为subSum
        if (currentSum == subSum) {
            // 递归计算第k-1个子堆能否被分配满所有元素之和为subSum
            return dfs(nums, k - 1, subSum, 0, 0, visited);
        }
        for (int i = startIdx; i < nums.length; i++) {
            // 当前下标元素已被分配，则跳过
            if (visited[i]) {
                continue;
            }
            // currentSum与当前下标元素值之后大于subSum，则跳过
            if (currentSum + nums[i] > subSum) {
                continue;
            }
            // 标记当前下标元素已被分配
            visited[i] = true;
            // 检测当前下标元素是否能被分配到第k个子集中
            if (dfs(nums, k, subSum, i + 1, currentSum + nums[i], visited)) {
                return true;
            } else {
                // 当前下标元素不能被分配到第k个子集中，回退已被分配标记
                visited[i] = false;
            }
        }
        return false;
    }
}
