package com.tuhailong.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 示例：
 * 输入: ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * 输出: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 * 注意：
 * 单词的定义是不包含空格的一系列字符
 * 输入字符串中不会包含前置或尾随的空格
 * 单词与单词之间永远是以单个空格隔开的
 * 进阶：使用 O(1) 额外空间复杂度的原地解法。
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-ii
 *
 * @author tuhailong
 * @since 2019-11-30
 */
public class LeetCode186 {
    // 两次反转，先对单个单词反转，然后整体反转
    public void reverseWords(char[] s) {
        int lid = 0;
        int rid = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                // 逐个单词反转
                reverse(s, lid, rid);
                lid = i + 1;
                continue;
            }
            rid = i;
        }
        // 对最后一个单词反转
        reverse(s, lid, rid);
        // 整体反转
        reverse(s, 0, s.length - 1);
    }

    private void reverse(char[] chs, int lid, int rid) {
        while (lid < rid) {
            chs[lid] ^= chs[rid];
            chs[rid] ^= chs[lid];
            chs[lid] ^= chs[rid];
            ++lid;
            --rid;
        }
    }

    public void reverseWordsBF(char[] s) {
        ArrayList<String> list = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                if (buffer.length() != 0) {
                    list.add(buffer.toString());
                }
                buffer = new StringBuffer();
                continue;
            }
            buffer.append(s[i]);
            if (i == s.length - 1) {
                if (buffer.length() != 0) {
                    list.add(buffer.toString());
                }
            }
        }
        String[] array = list.toArray(new String[list.size()]);
        int lid = 0;
        int rid = array.length - 1;
        while (lid < rid) {
            String tmp = array[lid];
            array[lid] = array[rid];
            array[rid] = tmp;
            ++lid;
            --rid;
        }
        int idx = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length(); j++) {
                s[idx++] = array[i].charAt(j);
            }
            if (i != array.length - 1) {
                s[idx++] = ' ';
            }
        }
        System.out.println(Arrays.toString(s));
    }

    public static void main(String[] args) {
        LeetCode186 ni = new LeetCode186();
        char[] chs = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        ni.reverseWords(chs);

    }
}
