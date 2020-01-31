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

// 两个链表的第一个公共结点
public class Test36 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1, p2 = pHead2;
        while (p1 != p2) {
            p1 = p1 != null ? p1.next : pHead2;
            p2 = p2 != null ? p2.next : pHead1;
        }
        return p1;
    }
}
