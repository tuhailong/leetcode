package com.tuhailong.leetcode;

import java.util.HashMap;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * 示例 1:
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 *
 * @author tuhailong
 * @since 2019-11-12
 */
class LeetCode82 {
    public ListNode deleteDuplicates(ListNode head) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode p = head;
        ListNode q = head;
        while (p != null) {
            map.put(p.val, map.getOrDefault(p.val, 0) + 1);
            p = p.next;
        }
        ListNode ans = new ListNode(0);
        ListNode cur = ans;
        while (q != null) {
            if (map.get(q.val) == 1) {
                cur.next = new ListNode(q.val);
                cur = cur.next;
            }
            q = q.next;
        }
        return ans.next;
    }

    public ListNode deleteDuplicatesOpted(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        if (head.val == next.val) {
            while (next != null && head.val == next.val) {
                next = next.next;
            }
            head = deleteDuplicates(next);
        } else {
            head.next = deleteDuplicates(next);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        p.next = new ListNode(1);
    }
}
