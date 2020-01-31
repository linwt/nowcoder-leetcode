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

// 链表中倒数第k个结点
public class Test14 {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }
        ListNode slow = head, fast = head;
        for (int i = 1; i < k; i++) {
            if (fast.next != null) {
                fast = fast.next;
            } else {
                return null;
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
