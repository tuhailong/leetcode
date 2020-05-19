package com.tuhailong.leetcode;

/**
 * 239. 滑动窗口最大值
 *
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 * 进阶：
 * 你能在线性时间复杂度内解决此题吗？
 * 示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *  
 * 提示：
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 *
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 *
 * @author tuhailong
 * @since 2020-05-19
 */
public class LeetCode0239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        int[] ans = new int[nums.length - k + 1];
        int maxIdx = -1;
        int max = Integer.MIN_VALUE;
        for (int idx = 0; idx < nums.length - k + 1; idx++) {
            if (maxIdx >= idx) {
                if (max <= nums[idx + k - 1]) {
                    max = nums[idx + k - 1];
                    maxIdx = idx + k - 1;
                }
            } else {
                max = nums[idx];
                for (int i = idx + 1; i < idx + k; i++) {
                    if (max < nums[i]) {
                        max = nums[i];
                        maxIdx = i;
                    }
                }
            }
            ans[idx] = max;
        }
        return ans;
    }

    public int[] maxSlidingWindowMine(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return new int[0];
        }
        int[] ans = new int[nums.length - k + 1];
        int lid = 0;
        int rid = k - 1;
        while (rid < nums.length) {
            int max = nums[lid];
            for (int i = lid + 1; i < lid + k; i++) {
                if (max < nums[i]) {
                    max = nums[i];
                }
            }
            ans[lid] = max;
            lid++;
            rid++;
        }
        return ans;
    }
}
