package com.tuhailong.leetcode;

import java.util.ArrayList;

/**
 * 对于一个压缩字符串，设计一个数据结构，它支持如下两种操作： next 和 hasNext。
 * 给定的压缩字符串格式为：每个字母后面紧跟一个正整数，这个整数表示该字母在解压后的字符串里连续出现的次数。
 * next() - 如果压缩字符串仍然有字母未被解压，则返回下一个字母，否则返回一个空格。
 * hasNext() - 判断是否还有字母仍然没被解压。
 * 注意：
 * 请记得将你的类在 StringIterator 中 初始化 ，因为静态变量或类变量在多组测试数据中不会被自动清空。
 * 示例：
 * StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");
 * iterator.next(); // 返回 'L'
 * iterator.next(); // 返回 'e'
 * iterator.next(); // 返回 'e'
 * iterator.next(); // 返回 't'
 * iterator.next(); // 返回 'C'
 * iterator.next(); // 返回 'o'
 * iterator.next(); // 返回 'd'
 * iterator.hasNext(); // 返回 true
 * iterator.next(); // 返回 'e'
 * iterator.hasNext(); // 返回 false
 * iterator.next(); // 返回 ' '
 * 链接：https://leetcode-cn.com/problems/design-compressed-string-iterator
 *
 * @author tuhailong
 * @since 2019-11-21
 */
class LeetCode604 {
    /**
     * 执行用时: 11 ms, 在所有 java 提交中击败了90.48%的用户
     * 内存消耗: 39.1 MB, 在所有 java 提交中击败了100.00%的用户
     */
    static class StringIterator {
        private class Node {
            char key;
            long val;

            Node(char ch, long cnt) {
                key = ch;
                val = cnt;
            }
        }

        private final ArrayList<Node> mList;

        public StringIterator(String compressedString) {
            mList = new ArrayList<>();
            if (compressedString != null) {
                char[] chs = compressedString.toCharArray();
                int i = 0;
                char ch = ' ';
                while (i < chs.length) {
                    if (Character.isLetter(chs[i])) {
                        ch = chs[i];
                        ++i;
                        continue;
                    }
                    long cnt = 0;
                    while (i < chs.length && Character.isDigit(chs[i])) {
                        cnt = cnt * 10 + (chs[i] - '0');
                        ++i;
                    }
                    Node node = new Node(ch, cnt);
                    mList.add(node);
                }
            }
        }

        public char next() {
            while (!mList.isEmpty()) {
                Node node = mList.remove(0);
                if (node.val > 0) {
                    node.val = node.val - 1;
                    if (node.val > 0) {
                        mList.add(0, node);
                    }
                    return node.key;
                }
            }
            return ' ';
        }

        public boolean hasNext() {
            return !mList.isEmpty();
        }
    }

    public static void main(String[] args) {
        StringIterator ni = new StringIterator("V8");
        System.out.println(ni.next());
        System.out.println(ni.next());
        System.out.println(ni.next());
        System.out.println(ni.next());
        System.out.println(ni.hasNext());
        System.out.println(ni.next());
        System.out.println(ni.next());
        System.out.println(ni.next());
        System.out.println(ni.hasNext());
        System.out.println(ni.next());
        System.out.println(ni.hasNext());
        System.out.println(ni.hasNext());
    }
}
