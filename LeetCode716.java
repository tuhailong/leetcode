package com.tuhailong.leetcode;

import java.util.ArrayList;

/**
 * 设计一个最大栈，支持 push、pop、top、peekMax 和 popMax 操作。
 * push(x) -- 将元素 x 压入栈中。
 * pop() -- 移除栈顶元素并返回这个值。
 * top() -- 返回栈顶元素。
 * peekMax() -- 返回栈中最大元素。
 * popMax() -- 返回栈中最大的元素，并将其删除。如果有多个最大元素，只要删除最靠近栈顶的那个。
 *
 * 样例 1:
 * MaxStack stack = new MaxStack();
 * stack.push(5);
 * stack.push(1);
 * stack.push(5);
 * stack.top(); -> 5
 * stack.popMax(); -> 5
 * stack.top(); -> 1
 * stack.peekMax(); -> 5
 * stack.pop(); -> 1
 * stack.top(); -> 5
 * 注释:
 * -1e7 <= x <= 1e7
 * 操作次数不会超过 10000。
 * 当栈为空的时候不会出现后四个操作。
 * 链接：https://leetcode-cn.com/problems/max-stack
 *
 * @author tuhailong
 * @since 2019-11-21
 */
class LeetCode716 {
    static class MaxStack {
        private final ArrayList<Integer> mArray;

        /** initialize your data structure here. */
        public MaxStack() {
            mArray = new ArrayList<>();
        }

        public void push(int x) {
            mArray.add(x);
        }

        public int pop() {
            if (mArray.isEmpty()) {
                throw new IllegalStateException("stack is empty");
            }
            return mArray.remove(mArray.size() - 1);
        }

        public int top() {
            if (mArray.isEmpty()) {
                throw new IllegalStateException("stack is empty");
            }
            return mArray.get(mArray.size() - 1);
        }

        public int peekMax() {
            if (mArray.isEmpty()) {
                throw new IllegalStateException("stack is empty");
            }
            int max = mArray.get(0);
            int len = mArray.size();
            for (int i = 1; i < len; i++) {
                max = Math.max(max, mArray.get(i));
            }
            return max;
        }

        public int popMax() {
            if (mArray.isEmpty()) {
                throw new IllegalStateException("stack is empty");
            }
            int max = mArray.get(0);
            int idx = 0;
            int len = mArray.size();
            for (int i = 1; i < len; i++) {
                int val = mArray.get(i);
                if (max <= val) {
                    max = val;
                    idx = i;
                }
            }
            return mArray.remove(idx);
        }
    }

    public static void main(String[] args) {
        MaxStack stack = new MaxStack();
        stack.push(5);
        stack.push(1);
        stack.push(5);
        stack.top();
        stack.popMax();
        stack.top();
        stack.peekMax();
        stack.pop();
        stack.top();
    }
}
