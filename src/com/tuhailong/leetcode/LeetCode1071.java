package com.tuhailong.leetcode;

/**
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 * 返回字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 * 示例 1：
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 * 示例 2：
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 * 示例 3：
 * 输入：str1 = "LEET", str2 = "CODE"
 * 输出：""
 * 提示：
 * 1 <= str1.length <= 1000
 * 1 <= str2.length <= 1000
 * str1[i] 和 str2[i] 为大写英文字母
 * 链接：https://leetcode-cn.com/problems/greatest-common-divisor-of-strings
 *
 * @author tuhailong
 * @since 2019-11-23
 */
public class LeetCode1071 {
    /**
     * 解题思路：欧几里得算法
     * 最大公因子存在的充要条件A+B=B+A。
     * 若存在公因子，则公因子的长度不大于(A长度-B长度绝对值，为新的A)与B长度的​最小值;循环直到A的长度等于B的长度​。
     */
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return new String();
        }
        while (true) {
            int diff = str1.length() - str2.length();
            if (diff == 0) {
                return str1;
            } else if (diff > 0) {
                str1 = str1.substring(str2.length());
            } else {
                str2 = str2.substring(str1.length());
            }
        }
    }

    public static void main(String[] args) {
        LeetCode1071 ni = new LeetCode1071();
        System.out.println(ni.gcdOfStrings("ABABAB", "ABAB"));
    }
}
