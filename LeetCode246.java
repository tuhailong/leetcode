package com.tuhailong.leetcode;

import java.util.HashSet;

/**
 * 中心对称数是指一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。
 * 请写一个函数来判断该数字是否是中心对称数，其输入将会以一个字符串的形式来表达数字。
 * 示例 1:
 * 输入:  "69"
 * 输出: true
 * 示例 2:
 * 输入:  "88"
 * 输出: true
 * 示例 3:
 * 输入:  "962"
 * 输出: false
 * 链接：https://leetcode-cn.com/problems/strobogrammatic-number
 *
 * @author tuhailong
 * @since 2019-11-18
 */
class LeetCode246 {
    private static final HashSet<Character> VALID_CHARS = new HashSet<>();
    static {
        VALID_CHARS.add('0');
        VALID_CHARS.add('1');
        VALID_CHARS.add('6');
        VALID_CHARS.add('8');
        VALID_CHARS.add('9');
    }

    public boolean isStrobogrammatic(String num) {
        if (num == null || num.isEmpty()) {
            return false;
        }
        char[] chs = num.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (!VALID_CHARS.contains(chs[i])) {
                return false;
            }
            if (chs[i] == '6') {
                chs[i] = '9';
                continue;
            }
            if (chs[i] == '9') {
                chs[i] = '6';
                continue;
            }
        }
        int lid = 0;
        int rid = chs.length - 1;
        while (lid < rid) {
            chs[lid] ^= chs[rid];
            chs[rid] ^= chs[lid];
            chs[lid] ^= chs[rid];
            ++lid;
            --rid;
        }
        return num.equals(new String(chs));
    }
}
