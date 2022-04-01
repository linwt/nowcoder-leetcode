// 203. 移除链表元素


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


/*
添加哨兵节点，下一节点有效则指向，无效则跳过
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode root = new ListNode(0, head);
        ListNode pre = root;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return root.next;
    }
}


/*
递归：
1、方法功能：入参是节点和目标值，判断当前节点是否有效，有效则返回当前节点，无效则返回下一节点
2、终止条件：节点为空时返回空
3、递归逻辑：
   1）每个节点都需要判断并返回有效节点，因此调用同样的方法
   2）当前节点的下一节点指针需要指向有效节点，因此调用递归得到的有效节点赋值给该指针
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        if (head.val == val) {
            return head.next;
        }
        return head;
    }
}