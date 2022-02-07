// 相交链表


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


/*
分别遍历两个链表，使用列表存放第一个链表的节点，遍历第二个链表的节点时，如果列表存在该节点，则为相交节点
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        List<ListNode> list = new ArrayList<>();
        while (headA != null) {
            list.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (list.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}


/*
双指针：使用两个指针都遍历两个链表，由于走的长度一致，最终会在某点相遇，该点就是相交起始结点，如果没相遇则都走到空指针
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A == null ? headB : A.next;
            B = B == null ? headA : B.next;
        }
        return A;
    }
}