package com.tuhailong.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 设计并实现一个 TwoSum 的类，使该类需要支持 add 和 find 的操作。
 * add 操作 -  对内部数据结构增加一个数。
 * find 操作 - 寻找内部数据结构中是否存在一对整数，使得两数之和与给定的数相等。
 * 示例 1:
 * add(1); add(3); add(5);
 * find(4) -> true
 * find(7) -> false
 * 示例 2:
 * add(3); add(1); add(2);
 * find(3) -> true
 * find(6) -> false
 * 链接：https://leetcode-cn.com/problems/two-sum-iii-data-structure-design
 *
 * @author tuhailong
 * @since 2019-11-18
 */

class LeetCode170 {
    class TwoSum {
        private final HashMap<Integer, Integer> mDataMap;

        /** Initialize your data structure here. */
        public TwoSum() {
            mDataMap = new HashMap<>();
        }

        /** Add the number to an internal data structure.. */
        public void add(int number) {
            mDataMap.put(number, mDataMap.getOrDefault(number, 0) + 1);
        }

        /** Find if there exists any pair of numbers which sum is equal to the value. */
        public boolean find(int value) {
            for (Map.Entry<Integer, Integer> entry : mDataMap.entrySet()) {
                int key = entry.getKey();
                int cnt = entry.getValue();
                int dif = value - key;
                if (dif == key) {
                    if (cnt >= 2) {
                        return true;
                    }
                } else {
                    if ((mDataMap.containsKey(dif))) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
