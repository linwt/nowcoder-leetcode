// 19. 删除链表的倒数第 N 个结点


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
快慢指针：快指针先走n步，然后快慢指针同时走，直到快指针走完链表，此时慢指针所指节点的下一节点是待删除节点，修改慢指针所指节点的下一节点指针指向为下下节点
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = new ListNode(0, head);
        ListNode slow = root;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return root.next;
    }
}


/*
栈：后进先出，全部入栈后弹出n个节点，第n个为待删除节点，此时栈顶节点为前驱节点，修改前驱节点的下一节点指针指向下下节点
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> stack = new Stack<>();
        ListNode root = new ListNode(0, head);
        ListNode cur = root;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (n > 0) {
            stack.pop();
            n--;
        }
        ListNode node = stack.peek();
        node.next = node.next.next;
        return root.next;
    }
}


/*
计数：遍历链表记录链表长度，计算待删除节点正数位置，再从头遍历到待删除节点的前驱节点位置，修改前驱节点的下一节点指针指向下下节点
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = new ListNode(0, head);
        ListNode cur = root;
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        for (int i = 0; i < len - n; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return root.next;
    }
}


/*
递归：累加计数
1、方法功能：传入节点，返回该节点的倒数位置个数。如果是目标删除位置，则修改链表指针指向下下个节点
2、终止条件：节点为空时，返回位置0
3、递归逻辑：
  1）调用递归方法，直接走到链表尾部，逐层累加计数返回
  2）接收递归返回值，判断该值是否为目标删除位置，是则说明下一节点是待删除节点，修改链表指针指向下下个节点
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return rec(head, n) == n ? head.next : head;
    }

    private int rec(ListNode head, int n) {
        if (head == null) {
            return 0;
        }
        int num = rec(head.next, n);
        if (num == n) {
            head.next = head.next.next;
        }
        return ++num;
    }
}


/*
递归：递减计数
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return track(head, n) == 0 ? head.next : head;
    }

    private int track(ListNode head, int num) {
        if (head == null) {
            return num;
        }
        num = track(head.next, num);
        if (num == 0) {
            head.next = head.next.next;
        }
        return --num;
    }
}