package com.tuhailong.leetcode.list;

import java.util.HashSet;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * <p>
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 *
 * @author tuhailong
 * @since 2019-11-12
 */
public class LeetCode0083 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode ans = new ListNode(0);
        ListNode cur = ans;
        HashSet<Integer> set = new HashSet<>();
        while (head != null) {
            if (set.add(head.val)) {
                cur.next = new ListNode(head.val);
                cur = cur.next;
            }
            head = head.next;
        }
        return ans.next;
    }

    public ListNode deleteDuplicatesOpted(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
