package offer;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/

// 删除链表中重复的结点
public class Test56 {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode head = new ListNode(0);
        head.next = pHead;
        ListNode pre = head, last = head.next;
        while (last != null) {
            if (last.next != null && last.val == last.next.val) {
                while (last.next != null && last.val == last.next.val) {
                    last = last.next;
                }
                pre.next = last.next;
                last = last.next;
            } else {
                pre = pre.next;
                last = last.next;
            }
        }
        return head.next;
    }
}
