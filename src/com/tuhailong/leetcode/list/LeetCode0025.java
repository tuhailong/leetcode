package com.tuhailong.leetcode.list;

/**
 * 25. K 个一组翻转链表
 * <p>
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例：
 * 给你这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * 说明：
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 *
 * @author tuhailong
 * @since 2020-05-21
 */
public class LeetCode0025 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        int count = 0;
        // 检查链表长度是否满足翻转
        ListNode node = head;
        while (count < k && node != null) {
            node = node.next;
            count++;
        }

        if (count == k) { // 满足条件, 进行翻转
            for (int i = 0; i < k && curr != null; i++) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            if (next != null) {
                // head为链表翻转后的尾节点
                head.next = reverseKGroup(next, k);
            }
            // prev为链表翻转后的头结点
            return prev;
        } else { // 不满足翻转条件, 直接返回head
            return head;
        }
    }
}
