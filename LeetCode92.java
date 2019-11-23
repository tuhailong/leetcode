package com.tuhailong.leetcode;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * 示例:
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 *
 * @author tuhailong
 * @since 2019-11-12
 */
class LeetCode92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(0);
        ListNode preNode = pre;
        ListNode mid = null;
        ListNode pos = new ListNode(0);
        ListNode posNode = pos;
        ListNode curr = head;
        int len = 0;
        while (curr != null) {
            ++len;
            if (len < m) {
                preNode.next = curr;
                preNode = preNode.next;
                curr = curr.next;
            } else if (len > n) {
                posNode.next = curr;
                posNode = posNode.next;
                curr = curr.next;
            } else {
                ListNode tmp = curr.next;
                curr.next = mid;
                mid = curr;
                curr = tmp;
            }
        }
        preNode.next = null;
        posNode.next = null;
        ListNode midNode = mid;
        while (midNode != null && midNode.next != null) {
            midNode = midNode.next;
        }
        midNode.next = pos.next;
        preNode.next = mid;
        return pre.next;
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
        LeetCode92 ni = new LeetCode92();
        ListNode ans = ni.reverseBetween(head, 2, 4);
        System.out.println(ans);
    }
}
