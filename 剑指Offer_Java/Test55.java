package offer;

import java.util.ArrayList;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/

// 链表中环的入口结点
public class Test55 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ArrayList<Integer> list = new ArrayList<>();
        while (pHead != null) {
            if (list.contains(pHead.val)) {
                return pHead;
            }
            list.add(pHead.val);
            pHead = pHead.next;
        }
        return null;
    }

    public ListNode EntryNodeOfLoop2(ListNode pHead) {
        if (pHead == null || pHead.next == null || pHead.next.next == null) {
            return null;
        }
        ListNode node = pHead, slow = pHead.next, fast = pHead.next.next;
        while (slow != fast) {
            if (slow.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            } else {
                return null;
            }
        }
        while (node != slow) {
            node = node.next;
            slow = slow.next;
        }
        return slow;
    }
}
