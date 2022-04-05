// 25. K 个一组翻转链表


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
1、指针含义
  1）root：哨兵节点
  2）pre：上一组链表的尾节点
  3）start：当前组链表的头节点
  4）end：当前组链表的尾节点
  5）next：下一组链表的头节点
2、当有下一组时，遍历k次找到新的当前组的尾节点end，如果不足k个节点则结束
3、标记下一组的头节点next，用于后续与上一组连接
4、标记当前组的头节点start，尾节点下一指针指向空，使得当前组链表独立
5、当前组链表反转，返回新的头节点，上一组链表的尾节点pre连接当前组新的头节点end，新的尾节点start连接下一组的头节点next
6、重新初始化指针指向，pre、end指向start，准备下一轮处理

  0  →     1  →  2  →  3  →     4  →  5  →  6  →     7  →  8
root/pre/end
=============================================================
  0  →     1  →  2  →  3  →     4  →  5  →  6  →     7  →  8
root/pre              end
=============================================================
  0  →     1  →  2  →  3        4  →  5  →  6  →     7  →  8
root/pre start        end      next
=============================================================
  0  →     3  →  2  →  1  →     4  →  5  →  6  →     7  →  8
root/pre  end        start     next
=============================================================
  0  →     3  →  2  →  1  →     4  →  5  →  6  →     7  →  8
root             pre/end/start next
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode root = new ListNode(0, head);
        ListNode pre = root;
        ListNode end = root;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode next = end.next;
            ListNode start = pre.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = start;
        }
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