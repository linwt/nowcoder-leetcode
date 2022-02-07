// 合并两个有序链表


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
递归思路：
1、终止条件：其中一个节点为空
2、方法功能：入参两个节点，比较值的大小，返回值较小的节点
3、递归逻辑：下一个有序节点同样可以通过调用这个方法得到，一次递归获得值较小的节点，返回给上一层拼接成链表，最后得到有序的链表
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}


/*
迭代思路：
1、创建一个新结点，用于最后返回链表头
2、使用pre指针，连接结点成链表
3、使用while循环判断并连接两个链表值较小的节点，链表的节点被连接后，该链表指针指向下一个节点继续判断
4、其中一个链表为空后循环结束，连接另一个不为空的链表的剩余部分
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode pre = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                pre.next = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }
        pre.next = list1 == null ? list2 : list1;
        return head.next;
    }
}