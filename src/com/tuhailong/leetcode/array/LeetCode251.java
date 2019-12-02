package com.tuhailong.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 请设计并实现一个能够展开二维向量的迭代器。该迭代器需要支持 next 和 hasNext 两种操作。、
 * 示例：
 * Vector2D iterator = new Vector2D([[1,2],[3],[4]]);
 * iterator.next(); // 返回 1
 * iterator.next(); // 返回 2
 * iterator.next(); // 返回 3
 * iterator.hasNext(); // 返回 true
 * iterator.hasNext(); // 返回 true
 * iterator.next(); // 返回 4
 * iterator.hasNext(); // 返回 false
 * 注意：
 * 请记得 重置 在 Vector2D 中声明的类变量（静态变量），因为类变量会 在多个测试用例中保持不变，影响判题准确。请 查阅 这里。
 * 你可以假定 next() 的调用总是合法的，即当 next() 被调用时，二维向量总是存在至少一个后续元素。
 * 链接：https://leetcode-cn.com/problems/flatten-2d-vector
 *
 * @author tuhailong
 * @since 2019-12-02
 */
class LeetCode251 {
    class Vector2D {
        int mIndex = 0;
        private List<Integer> mList;

        public Vector2D(int[][] v) {
            mList = new ArrayList<>();
            for (int i = 0; i < v.length; i++) {
                for (int j = 0; j < v[i].length; j++) {
                    mList.add(v[i][j]);
                }
            }
        }

        public int next() {
            return mList.get(mIndex++);
        }

        public boolean hasNext() {
            return mIndex < mList.size();
        }
    }
}
