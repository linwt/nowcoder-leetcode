// 6. 从尾到头打印链表


/*
class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}
*/


/*
递归
 */
public class Solution {
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


/*
列表：遍历节点，列表存放节点值，每次插入到头部
 */
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(0, listNode.val);
            listNode = listNode.next;
        }
        return list;
    }
}