package com.tuhailong.leetcode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 *
 * @author tuhailong
 * @since 2019-10-30
 */
class LeetCode14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String ret = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(ret) != 0) {
                ret = ret.substring(0, ret.length() - 1);
            }
        }
        return ret;

        /*
        for (int i = 1; i < strs.length; i++) {
            int len = Math.min(ret.length(), strs[i].length());
            StringBuilder prefixs = new StringBuilder();
            for (int idx = 0; idx < len; idx++) {
                if (ret.charAt(idx) == strs[i].charAt(idx)) {
                    prefixs.append(ret.charAt(idx));
                } else {
                    break;
                }
            }
            ret = prefixs.toString();
        }
        return ret;
         */
    }
}
