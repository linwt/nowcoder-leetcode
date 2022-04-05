// 92. 反转链表 II


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
“25.K个一组翻转链表”是反转多次，逻辑相似
1、指针含义
  1）root：哨兵节点
  2）pre：反转区域前的尾节点
  3）start：反转区域的头节点
  4）end：反转区域的尾节点
  5）next：反转区域后的头节点
2、pre、end根据给定的区域范围走到指定位置，标记start、next
3、end下一指针指向空，使得反转区域链表独立
4、反转区域链表反转，返回新的头节点，pre连接新的头节点end，新的尾节点连接next

  0  →  1  →  2  →     3  →  4  →  5  →     6  →  7  →  8
root/pre/end
=============================================================
  0  →  1  →  2  →     3  →  4  →  5        6  →  7  →  8
root         pre     start        end      next
=============================================================
  0  →  1  →  2  →     5  →  4  →  3  →     6  →  7  →  8
root         pre      end        start     next
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode root = new ListNode(0, head);
        ListNode pre = root, end = root, start, next;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }
        for (int i = 0; i < right; i++) {
            end = end.next;
        }
        next = end.next;
        start = pre.next;
        end.next = null;
        pre.next = reverse(start);
        start.next = next;
        return root.next;
    }

    // 206.反转链表
    private ListNode reverse(ListNode head) {
        ListNode before = null, after;
        while (head != null) {
            after = head.next;
            head.next = before;
            before = head;
            head = after;
        }
        return before;
    }
}