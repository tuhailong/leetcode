package com.tuhailong.leetcode;

/**
 * 给定已经按升序排列、由不同整数组成的数组 A，返回满足 A[i] == i 的最小索引 i。
 * 如果不存在这样的 i，返回 -1。
 * 示例 1：
 * 输入：[-10,-5,0,3,7]
 * 输出：3
 * 解释：
 * 对于给定的数组，A[0] = -10，A[1] = -5，A[2] = 0，A[3] = 3，因此输出为 3 。
 * 示例 2：
 * 输入：[0,2,5,8,17]
 * 输出：0
 * 示例：
 * A[0] = 0，因此输出为 0 。
 * 示例 3：
 * 输入：[-10,-5,3,4,7,9]
 * 输出：-1
 * 解释：
 * 不存在这样的 i 满足 A[i] = i，因此输出为 -1 。
 * 提示：
 * 1 <= A.length < 10^4
 * -10^9 <= A[i] <= 10^9
 * 链接：https://leetcode-cn.com/problems/fixed-point
 *
 * @author tuhailong
 * @since 2019-11-22
 */
class LeetCode1064 {
    public int fixedPoint(int[] A) {
        int lid = 0;
        int rid = A.length - 1;
        while (lid < rid) {
            int mid = (lid + rid) / 2;
            if (A[mid] > 0) {
                rid = mid - 1;
            } else if (A[mid] < 0) {
                lid = mid + 1;
            } else {
                lid = mid;
                break;
            }
        }
        for (int i = lid; i < A.length; i++) {
            if (A[i] == i) {
                return i;
            }
        }
        return -1;
    }

    public int fixedPointBF(int[] A) {
        int ret = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == i) {
                ret = i;
                break;
            }
        }
        return ret == Integer.MIN_VALUE ? -1 : ret;
    }

    public static void main(String[] args) {
        LeetCode1064 ni = new LeetCode1064();
        System.out.println(ni.fixedPoint(new int[]{-10,-5,-2,0,4,5,6,7,8,9,10}));
    }
}
