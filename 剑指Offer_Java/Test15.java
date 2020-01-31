package offer;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

// 反转链表
public class Test15 {
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
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
