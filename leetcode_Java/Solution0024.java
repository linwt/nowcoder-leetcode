// 24. 两两交换链表中的节点


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
递归：
1、方法功能：入参是一个节点，修改当前节点和下一节点指针方向，交换两个节点，返回新的头节点
2、终止条件：head或head.next为空则直接返回头节点，因为交换至少需要两个节点
3、返回结果：交换完成后新的头节点
4、递归逻辑：
  1）两个节点交换完成后，新的尾节点连接着后续链表的头节点，而后续链表的头节点需要同样的交换操作，因此调用同样的方法递归处理
  2）0个、1个节点的情况在终止条件中包含，单层递归时可以把链表当成只有2个或3个节点的简单情况，前两个节点交换完成后，连接着第三个节点newHead.next，
    newHead.next作为新的头节点，同样需要交换，因此调用同样的方法

   1    2    3    4
   ↑    ↑
 head newHead
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }
}


/*
递归：
思路同上。上一解法第三个节点用newHead.next获取，所以要先连接好第三个节点后，newHead.next指针才能移动。
本解法第三个节点直接用一个新的指针temp标记，所以可以先移动newHead.next指针，不会丢失第三个节点的引用。

   1      2    3    4
   ↑      ↑    ↑
 head newHead temp
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head.next.next;
        ListNode newHead = head.next;
        newHead.next = head;
        head.next = swapPairs(temp);
        return newHead;
    }
}


/*
迭代：
1、多指针标记用到的节点
2、修改节点指针方向
3、重新初始化指针，标记下一次交换的节点

  0        1    2    3    4
  ↑        ↑    ↑
root/pre start end
============================
  0    2    1    3    4
  ↑         ↑    ↑    ↑
root       pre start end
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode root = new ListNode(0, head);
        ListNode pre = root;
        while (pre.next != null && pre.next.next != null) {
            ListNode start = pre.next;
            ListNode end = pre.next.next;
            pre.next = end;
            start.next = end.next;
            end.next = start;
            pre = start;
        }
        return root.next;
    }
}