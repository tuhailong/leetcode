package com.tuhailong.leetcode.list;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 *
 * @author tuhailong
 * @since 2019-10-29
 */
public class LeetCode0021 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode pre = ans;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = (l1 != null) ? l1 : l2;
        return ans.next;
    }

    public static void main(String[] args) {

    }
}
