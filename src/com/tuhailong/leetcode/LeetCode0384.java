package com.tuhailong.leetcode;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

/**
 * 384. 打乱数组
 *
 * 打乱一个没有重复元素的数组。
 * 示例:
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 *
 * 链接：https://leetcode-cn.com/problems/shuffle-an-array
 *
 * @author tuhailong
 * @since 2020-05-20
 */
public class LeetCode0384 {
    class Solution {
        private int[] mArray;
        private Random mRandom = new Random();

        public Solution(int[] nums) {
            this.mArray = nums;
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return this.mArray;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            int[] nums = mArray.clone();
            int len = nums.length;
            for (int idx = 0; idx < len; idx++) {
                int randomIdx = idx + mRandom.nextInt(len - idx);
                swap(nums, idx, randomIdx);
            }
            return nums;
        }

        private void swap(int[] nums, int idx1, int idx2) {
            if (nums[idx1] == nums[idx2]) {
                return;
            }
            nums[idx1] ^= nums[idx2];
            nums[idx2] ^= nums[idx1];
            nums[idx1] ^= nums[idx2];
        }
    }
}
