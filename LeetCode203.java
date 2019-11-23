package com.tuhailong.leetcode;

/**
 * 删除链表中等于给定值 val 的所有节点。
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * 链接：https://leetcode-cn.com/problems/remove-linked-list-elements
 *
 * @author tuhailong
 * @since 2019-11-12
 */
public class LeetCode203 {

    public ListNode removeElements(ListNode head, int val) {
        // 移除链表首部结点值等于val的节点
        while (head != null) {
            if (head.val != val) {
                break;
            }
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        ListNode cp = head;
        ListNode np = head.next;
        while (np != null) {
            if (np.val == val) {
                // 下个结点值等于val,则将当前结点的next指针指向下个结点的next位置
                cp.next = np.next;
            } else {
                // 下个结点值不等于val,则将当前结点的指针指向当前结点的next位置
                cp = cp.next;
            }
            // 更新下个结点的位置，指向下个结点的next位置
            np = cp.next;
        }
        return head;
    }

}
