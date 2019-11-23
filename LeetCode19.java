package com.tuhailong.leetcode;

/**
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
 * @since 2019-10-31
 */
class LeetCode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode tmp = head;
        while (tmp != null) {
            ++len;
            tmp = tmp.next;
        }
        if (n == len) {
            head = head.next;
            return head;
        }
        n -= len;
        ListNode ans = new ListNode(-1);
        ans.next = head;
        tmp = ans;
        while (n > 0) {
            n--;
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        return ans.next;
    }
}
