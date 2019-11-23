package com.tuhailong.leetcode;

/**
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * 示例 1:
 * 输入: head = [4,5,1,9], node = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 * 输入: head = [4,5,1,9], node = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * 说明:
 * 链表至少包含两个节点。
 * 链表中所有节点的值都是唯一的。
 * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 * 不要从你的函数中返回任何结果。
 * 链接：https://leetcode-cn.com/problems/delete-node-in-a-linked-list
 *
 * @author tuhailong
 * @since 2019-11-11
 */
class LeetCode237 {
    ListNode head = null;

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public ListNode swap(ListNode head, int k) {
        int len = 0;
        ListNode p = head;
        ListNode q = head;
        while (q != null) {
            ++len;
            q = q.next;
        }
        int idx = 0;
        int[] arr = new int[len];
        while (p != null) {
            arr[idx++] = p.val;
            p = p.next;
        }
        arr[k - 1] ^= arr[len - k];
        arr[len - k] ^= arr[k - 1];
        arr[k - 1] ^= arr[len - k];
        ListNode ans = new ListNode(-1);
        ListNode r = ans;
        for (int i = 0; i < idx; i++) {
            r.next = new ListNode(arr[i]);
            r = r.next;
        }
        return ans.next;
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
        ListNode ans = new LeetCode237().swap(head, 2);
        System.out.println(ans);
    }
}
