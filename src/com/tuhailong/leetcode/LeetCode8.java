package com.tuhailong.leetcode;

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * 说明：
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 * 示例 1:
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 *      因此无法执行有效的转换。
 * 示例 5:
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231)。
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 *
 * @author tuhailong
 * @since 2019-10-30
 */
class LeetCode8 {
    public int myAtoi(String str) {
        int ans = 0;
        if (str == null || str.isEmpty()) {
            return ans;
        }
        int len = str.length();
        int idx = 0;
        boolean neg = false;
        boolean signDone = false;
        while (idx < len) {
            char tmp = str.charAt(idx);
            if (tmp == ' ') {
                idx++;
                continue;
            }
            if (tmp == '+') {
                if (signDone) {
                    return 0;
                }
                if (idx + 1 < len && str.charAt(idx + 1) == ' ') {
                    return 0;
                }
                idx++;
                signDone = true;
                continue;
            }
            if (tmp == '-') {
                if (signDone) {
                    return 0;
                }
                if (idx + 1 < len && str.charAt(idx + 1) == ' ') {
                    return 0;
                }
                idx++;
                neg = true;
                signDone = true;
                continue;
            }
            break;
        }
        if (idx >= len) {
            return 0;
        }
        char tmp = str.charAt(idx);
        if (tmp < '0' || tmp > '9') {
            return 0;
        }
        while (idx < len) {
            tmp = str.charAt(idx);
            if (tmp < '0' || tmp > '9') {
                break;
            }
            if (ans >= Integer.MAX_VALUE / 10) {
                break;
            }
            ans = ans * 10 + (tmp - '0');
            idx++;
        }
        if (idx >= len) {
            return neg ? -ans : ans;
        }
        tmp = str.charAt(idx);
        if (tmp >= '0' && tmp <= '9') {
            if (ans == Integer.MAX_VALUE / 10) {
                if (neg) {
                    if (tmp < '8') {
                        ans = ans * 10 + (tmp - '0');
                        return -ans;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                } else {
                    if (tmp < '7') {
                        ans = ans * 10 + (tmp - '0');
                        return ans;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                }
            }
            if (ans > Integer.MAX_VALUE / 10) {
                return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return neg ? -ans : ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode8().myAtoi("2147483800"));
    }
}