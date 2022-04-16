// 142. 环形链表 II


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
思路：使用列表存放节点对象，遍历链表，如果节点对象在列表中出现过则该节点为开始入环的第一个节点
注意：列表不能存放节点值，值可能一样，值一样的对象地址不一样，是唯一的
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            if (list.contains(head)) {
                return head;
            }
            list.add(head);
            head = head.next;
        }
        return null;
    }
}


/*
使用HashMap存放节点对象
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashMap<ListNode, Integer> map = new HashMap();
        while (head != null) {
            if (map.getOrDefault(head, 0) == 1) {
                return head;
            }
            map.put(head, 1);
            head = head.next;
        }
        return null;
    }
}


/*
快慢指针：
1、慢指针走一步，快指针走两步
2、如果没有环，则快指针会走到空指针
3、如果有环，假设在环中，以快指针为起点，快指针距离慢指针n步，那么当慢指针走n步后的位置为2n，刚好快指针也走2n步，所以快慢指针会相遇
4、入环口位置分析：
  1）设非环部分长度为a，环部分长度为b，快慢相遇时，慢指针走了s，快指针走了2s，快指针比慢指针多走了n次b，所以2s=s+nb，即s=nb
  2）从链表头部走到入环口需要a+nb步。即走a步到了入环口，每绕一圈b步都会回到入环口
  3）由s=nb知慢指针已经走了nb步，走到入环口需要a+nb步，所以慢指针再走a步就可以到入环口了，而从链表头部走到入环口也是a步，所以慢指针与头指针继续走直到相遇的位置就是入环口

1 → 2 → 3 → 4 → 5
            ↑   ↓
            7 ← 6
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (head != slow) {
                    head = head.next;
                    slow = slow.next;
                }
                return head;
            }
        }
        return null;
    }
}