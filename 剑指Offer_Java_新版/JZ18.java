// 18. 删除链表的节点


/*
三个指针定位：
root：指向头节点的指针，用于删除节点后返回新链表头节点
head：指向当前遍历节点的指针，用于获取节点值
pre：指向遍历节点的前一节点指针，方便修改下一指针指向，以此删除节点
 */
public class Solution {
    public ListNode deleteNode (ListNode head, int val) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode pre = root;
        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
                head.next = null;
                break;
            }
            head = head.next;
            pre = pre.next;
        }
        return root.next;
    }
}