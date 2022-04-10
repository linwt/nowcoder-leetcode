// 148. 排序链表


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
递归，归并排序：
1、方法功能：通过快慢指针找到链表中点，将链表拆分成两个链表，然后“21.合并两个有序链表”，返回新链表头节点
2、终止条件：节点为空 或 下一节点为空，则直接返回该节点，因为至少需要两个节点才能排序
3、递归逻辑：传入节点拆分成两个链表后，对两个链表有序合并。拆分后的两个新链表需要同样的操作，因此调用递归方法处理
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(newHead);
        ListNode root = new ListNode(0);
        ListNode cur = root;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left != null ? left : right;
        return root.next;
    }
}


/*
优先级队列升序排序，再弹出节点修改下一指针连接方向
 */
class Solution {
    public ListNode sortList(ListNode head) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((x, y) -> x.val - y.val);
        while (head != null) {
            queue.add(head);
            head = head.next;
        }
        ListNode root = new ListNode(0);
        ListNode cur = root;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            cur.next = node;
            cur = cur.next;
        }
        cur.next = null;
        return root.next;
    }
}


/*
节点值存入列表，升序排序，再取出创建节点连接成链表
 */
class Solution {
    public ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Collections.sort(list);
        ListNode root = new ListNode(0);
        ListNode cur = root;
        for (int val : list) {
            ListNode node = new ListNode(val);
            cur.next = node;
            cur = cur.next;
        }
        return root.next;
    }
}