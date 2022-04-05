// 23. 合并K个升序链表


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
顺序合并：遍历链表数组，逐个链表进行合并
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode root = null;
        for (ListNode head : lists) {
            root = mergeTwoLists(root, head);
        }
        return root;
    }

    // 21.合并两个有序链表
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode pre = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                pre.next = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }
        pre.next = list1 == null ? list2 : list1;
        return head.next;
    }
}


/*
分治合并：
1、终止条件：左右边界相同则返回对应链表，左边界大于右边界则返回空
2、方法功能：入参链表数组、左边界、右边界，将链表数组拆分成两个链表，合并链表返回
3、递归逻辑：数组拆分后，左右两部分数组仍然需要继续拆分，直到获得两个链表进行合并，因此调用同个方法进行处理，合并后的链表返回给上一层继续合并
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        return mergeTwoLists(merge(lists, left, mid), merge(lists, mid + 1, right));
    }

    // 21.合并两个有序链表
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode pre = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                pre.next = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }
        pre.next = list1 == null ? list2 : list1;
        return head.next;
    }
}