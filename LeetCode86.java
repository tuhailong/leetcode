package com.tuhailong.leetcode;


import java.util.ArrayList;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 示例:
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 * 链接：https://leetcode-cn.com/problems/partition-list
 *
 * @author tuhailong
 * @since 2019-11-12
 */
class LeetCode86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int lessIdx = 0;
        ListNode ptr = head;
        while (ptr != null) {
            if (ptr.val < x) {
                list.add(lessIdx++, ptr.val);
            } else {
                list.add(ptr.val);
            }
            ptr = ptr.next;
        }
        ListNode ans = new ListNode(0);
        ListNode cur = ans;
        for (int num : list) {
            cur.next = new ListNode(num);
            cur = cur.next;
        }
        return ans.next;
    }

    public ListNode partitionOpted(ListNode head, int x) {
        // before and after are the two pointers used to create the two list
        // before_head and after_head are used to save the heads of the two lists.
        // All of these are initialized with the dummy nodes created.
        ListNode beforeHead = new ListNode(0);
        ListNode before = beforeHead;
        ListNode afterHead = new ListNode(0);
        ListNode after = afterHead;
        while (head != null) {
            // If the original list node is lesser than the given x,
            // assign it to the before list.
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                // If the original list node is greater or equal to the given x,
                // assign it to the after list.
                after.next = head;
                after = after.next;
            }
            // move ahead in the original list
            head = head.next;
        }
        before.next = null;
        // Last node of "after" list would also be ending node of the reformed list
        after.next = null;
        // Once all the nodes are correctly assigned to the two lists,
        // combine them to form a single list which would be returned.
        before.next = afterHead.next;
        return beforeHead.next;
    }
}
