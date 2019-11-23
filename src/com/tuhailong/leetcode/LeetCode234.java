package com.tuhailong.leetcode;

/**
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 *
 * @author tuhailong
 * @since 2019-10-29
 */
public class LeetCode234 {

    // 翻转链表的后半部分，然后对比前后是否相等即可
    public boolean isPalindrome(ListNode head) {
        if ((head == null) || (head.next == null)) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while ((fast != null) && (fast.next != null)) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = reverse(slow);
        ListNode p = slow;
        while ((p != null) && (head != slow)) {
            if (head.val != p.val) {
                return false;
            }
            p = p.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tmpNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmpNext;
        }
        return prev;
    }
}
