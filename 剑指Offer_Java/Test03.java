package offer;

import java.util.ArrayList;

/*
class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}
*/

// 	从尾到头打印链表
public class Test03 {
    private ArrayList<Integer> list = new ArrayList<Integer>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return list;
        }
        printListFromTailToHead(listNode.next);
        list.add(listNode.val);
        return list;
    }
}
