// 两数相加


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


/*
1、同时遍历两个链表，对应位置的值相加，且加上进位值，计算新的进位值，创建新的节点
2、两个链表长度不同，则短链表后面默认为0
3、链表遍历结束后，如果进位值为1，需要再加一个节点
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int add = 0;
        while (l1 != null || l2 != null || add != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int num = l1Val + l2Val + add;
            add = num / 10;
            cur.next = new ListNode(num % 10);
            cur = cur.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return head.next;
    }
}