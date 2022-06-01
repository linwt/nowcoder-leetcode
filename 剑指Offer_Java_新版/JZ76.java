// 76. 删除链表中重复的结点


public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode root = new ListNode(0);
        root.next = pHead;
        ListNode pre = root, last = root.next;
        while (last != null) {
            if (last.next != null && last.val == last.next.val) {
                while (last.next != null && last.val == last.next.val) {
                    last = last.next;
                }
                pre.next = last.next;
            } else {
                pre = pre.next;
            }
            last = last.next;
        }
        return root.next;
    }
}
