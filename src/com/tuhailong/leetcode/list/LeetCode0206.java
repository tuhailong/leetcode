package com.tuhailong.leetcode.list;

/**
 * 反转一个单链表。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 *
 * @author tuhailong
 * @since 2019-10-30
 */
public class LeetCode0206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode curNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = curNext;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(3);
        p = p.next;
        p.next = new ListNode(4);
        p = p.next;
        p.next = new ListNode(5);
        LeetCode0206 ni = new LeetCode0206();
        ListNode tmps = ni.reverseList(head);
        System.out.println(tmps);
    }
}
