// 82. 删除排序链表中的重复元素 II


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
1、方法功能：入参是一个节点，判断该节点是否重复，不重复则返回该节点，否则往下遍历找到第一个与该节点不相同的节点后返回
2、终止条件：节点为空 或 下一节点为空，则直接返回，因为至少需要两个节点才需要判断删除
3、递归逻辑：先根据一个节点的情况进行处理，处理完后下一节点同样需要判断处理，则调用同样的方法递归处理
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val != head.next.val) {
            head.next = deleteDuplicates(head.next);
            return head;
        } else {
            ListNode temp = head.next;
            while (temp != null && head.val == temp.val) {
                temp = temp.next;
            }
            return deleteDuplicates(temp);
        }
    }
}


/*
一次遍历，改变节点指针：
1、至少要有两个节点才需要判断删除，否则直接返回
2、初始化pre、cur的位置，两者相邻。pre表示前一个有效节点的指针
3、当cur下一节点值与当前相同时，则cur继续往右走，走到最后一个值相同的节点
4、如果pre下一节点还是cur，说明中间没有重复节点，pre往右走一步即可。
  如果pre下一节点不是cur，说明中间有重复节点，包括cur在内的节点都要删除，即pre下一指针指向cur下一指针节点。此时pre还不能动，因为新的cur可能还是重复节点
5、经过一轮判断处理后，cur往右走一步。此时pre、cur回到初始状态

  0   →   1   →   2   →   3   →   3   →   4   →   4   →   5
root/pre cur
===========================================================
  0   →   1   →   2   →   3   →   3   →   4   →   4   →   5
root     pre     cur
===========================================================
  0   →   1   →   2   →   3   →   3   →   4   →   4   →   5
root             pre     cur
===========================================================
  0   →   1   →   2   →   3   →   3   →   4   →   4   →   5
root             pre             cur
===========================================================
  0   →   1   →   2   →                   4   →   4   →   5
root             pre                     cur
===========================================================
  0   →   1   →   2   →                   4   →   4   →   5
root             pre                             cur
===========================================================
  0   →   1   →   2   →                                   5
root             pre                                     cur
===========================================================
  0   →   1   →   2   →                                   5
root                                                     pre   cur
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode root = new ListNode(0, head);
        ListNode pre = root, cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            if (pre.next == cur) {
                pre = pre.next;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return root.next;
    }
}


/*
记录个数，改变节点指针：
1、上一解法是cur直接走到最后一个重复节点位置，一次性跳过多个重复节点
  当前解法是cur一步一步走，根据map中记录的出现次数决定是否跳过cur节点
2、先遍历一次，记录每个节点值出现次数
3、再次遍历，如果节点出现次数大于1则跳过
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Map<Integer, Integer> map = new HashMap<>();
        ListNode temp = head;
        while (temp != null) {
            map.put(temp.val, map.getOrDefault(temp.val, 0) + 1);
            temp = temp.next;
        }
        ListNode root = new ListNode(0, head);
        ListNode pre = root, cur = head;
        while (cur != null) {
            if (map.get(cur.val) == 1) {
                pre = pre.next;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return root.next;
    }
}