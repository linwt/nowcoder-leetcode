// 141. 环形链表


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


/*
思路：使用列表存放节点对象，遍历链表，如果节点对象在列表中出现过则有环，否则无环
注意：列表不能存放节点值，值可能一样，值一样的对象地址不一样，是唯一的
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            if (list.contains(head)) {
                return true;
            }
            list.add(head);
            head = head.next;
        }
        return false;
    }
}


/*
使用HashMap存放节点对象
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashMap<ListNode, Integer> map = new HashMap();
        while (head != null) {
            if (map.getOrDefault(head, 0) == 1) {
                return true;
            }
            map.put(head, 1);
            head = head.next;
        }
        return false;
    }
}


/*
快慢指针：
1、慢指针走一步，快指针走两步
2、如果没有环，则快指针会走到空指针
3、如果有环，则慢指针走完一圈，快指针刚好走完两圈，两者同时回到原点
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}