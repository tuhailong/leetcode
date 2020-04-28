package com.tuhailong.leetcode.list;

/**
 * 删除链表的倒数第N个节点
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * 给定的 n 保证是有效的。
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 *
 * @author tuhailong
 * @since 2020-04-28
 */
public class LeetCode0019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int cnt = 0;
        ListNode node = head;
        while (node != null) {
            ++cnt;
            node = node.next;
        }
        int idx = cnt - n;
        if (idx == 0) {
            head = head.next;
            return head;
        }

        ListNode prevNode = null;
        ListNode currNode = head;
        ListNode postNode = head.next;
        while (idx-- > 0) {
            prevNode = currNode;
            currNode = postNode;
            postNode = postNode.next;
        }
        prevNode.next = prevNode.next.next;
        return head;
    }

    public ListNode removeNthFromEndOpted(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
