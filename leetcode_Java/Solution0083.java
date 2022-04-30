// 83. 删除排序链表中的重复元素


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
1、创建哨兵节点标记链表头部，用于删除节点后返回链表
2、使用前后两个指针pre、head来标记节点位置，通过判断head不为空来循环遍历，从而保证能获取前后两个节点的值来判断
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode root = new ListNode(-101, head);
        ListNode pre = root;
        while (head != null) {
            if (head.val == pre.val) {
                pre.next = head.next;
            } else {
                pre = head;
            }
            head = head.next;
        }
        return root.next;
    }
}


/*
1、head为链表头部不变，用于删除节点后返回链表
2、使用一个指针cur标记节点，通过判断cur和cur.next不为空来循环遍历，从而保证能获取前后两个节点的值来判断
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}