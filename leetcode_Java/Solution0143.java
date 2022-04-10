// 143. 重排链表


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
注意：不是使用第三个链表去重新连接原链表，而是直接获取原链表节点改变其指针指向
1、使用列表存放节点，双指针从头尾取节点，改变节点连接顺序
2、left、right指针指向的节点表示 准备用来修改它的下一指针方向的节点
3、奇数个节点时，最后一次指针移动是right指针左移，此时 left == right 进入不了下一轮循环
  偶数个节点时，最后一次指针移动是left指针右移，此时 left == right，由于程序下面还有右指针节点处理逻辑，所以需要提前跳出循环

  1  2  3           1  2  3  4
  ↑     ↑           ↑        ↑
left  right        left    right

  1   2   3   4   5   6   7
left                    right
==============================
  1   2   3   4   5   6   7
    left            right
==============================
  1 → 7 → 2
 */
class Solution {
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int left = 0, right = list.size() - 1;
        while (left < right) {
            list.get(left).next = list.get(right);
            left++;
            if (left == right) {
                break;
            }
            list.get(right).next = list.get(left);
            right--;
        }
        list.get(left).next = null;
    }
}


/*
思路：利用快慢指针找到链表中点，链表后半部分反转得到新链表，两个链表从头开始改变对应节点指针方向
1、前三个节点为空则直接结束，因为交换至少需要三个节点
2、快慢指针从头节点开始，慢指针每次走一步，快指针每次走两步。
   快指针遇到空时说明走到末尾了，fast.next为空是奇数个节点的情况，fast.next.next为空是偶数个节点的情况
3、后半部分链表反转，前半部分尾部断开，形成两个链表
4、两个链表从头开始，改变对应节点的指针方向

   1   →   2   →   3   →   4   →   5   →   6   →   7
head/slow/fast
====================================================
   1   →   2   →   3   →   4   →   5   →   6   →   7
 head                     slow                   fast
====================================================
   1   →   2   →   3   →   4       7   →   6   →   5
 head                          newHead newHeadNext
====================================================
   1   →   7   →   2   →   3   →   4       6   →   5
 head   newHead                        newHeadNext
====================================================
   1   →   7   →   2   →   3   →   4       6   →   5
                  head                 newHead newHeadNext
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = reverse(slow.next);
        slow.next = null;
        while (newHead != null) {
            ListNode newHeadNext = newHead.next;
            newHead.next = head.next;
            head.next = newHead;
            head = newHead.next;
            newHead = newHeadNext;
        }
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


/*
递归
 */
class Solution {
    public void reorderList(ListNode head) {
        int count = 0;
        ListNode cur = head;
        while(cur != null){
            cur = cur.next;
            count++;
        }
        if(count <= 2) {
            return;
        }
        reorderList(head, count);
    }

    private ListNode reorderList(ListNode head, int count){
        if(count == 1) {
            return head;
        } else if (count == 2) {
            return head.next;
        }
        ListNode midTail = reorderList(head.next, count - 2);
        ListNode headNext = head.next;
        ListNode after = midTail.next;
        midTail.next = after.next;
        head.next = after;
        after.next = headNext;
        return midTail;
    }
}