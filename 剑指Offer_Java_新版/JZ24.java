// 24. 反转链表


public class Solution {
    public ListNode ReverseList(ListNode head) {
        ListNode pre = null, after = null;
        while (head != null) {
            after = head.next;
            head.next = pre;
            pre = head;
            head = after;
        }
        return pre;
    }
}
