// 回文链表


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
节点值存入列表，双指针从首尾到中间移动判断元素是否对称一样
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int l = 0, r = list.size() - 1;
        while (l < r) {
            if (list.get(l++) != list.get(r--)) {
                return false;
            }
        }
        return true;
    }
}


/*
递归：
1、通过递归实现在链表上双指针判断首尾元素是否一样
2、使用成员变量作为头部指针，该指针不受递归影响，每次判断完向后移动一步
3、通过递归直接到达链表尾部指针，此时通过首尾指针判断元素是否一样，下一层递归结束后返回上一层，相当于尾部指针往前移动一步
4、先判断上一层处理结果元素是否一样，是的话再判断当前层元素是否一样
 */
class Solution {
    private ListNode left;

    public boolean isPalindrome(ListNode head) {
        left = head;
        return recursivelyCheck(head);
    }

    private boolean recursivelyCheck(ListNode right) {
        if (right == null) {
            return true;
        }
        if (!recursivelyCheck(right.next)) {
            return false;
        }
        if (right.val != left.val) {
            return false;
        }
        left = left.next;
        return true;
    }
}


/*
快指针走到末尾，慢指针刚好到中间，其中慢指针将前半部分反转，然后从中间到首尾比较
原始：1 → 2 → 3 → 4 → 3 → 2 → 1
反转：1 ← 2 ← 3 ← 4 → 3 → 2 → 1
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head, pre = null, temp;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            temp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = temp;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (pre != null && slow != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }
}