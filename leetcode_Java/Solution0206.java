// 反转链表


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
迭代：使用三个指针分别指向前一个、当前、下一个结点 来定位位置，从头到尾改变链表节点连接的指针方向
 */
class Solution {
    public ListNode reverseList(ListNode head) {
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
递归：
1、终止条件：节点为空 或 节点的下一节点为空
2、方法功能：改变指针方向，返回新的头节点
3、递归思路：
   1）递归传入下一个节点，目的是为了到达最后一个节点，从尾到头改变链表节点连接的指针方向
   2）原先 A → B，改变指针方向，变成 A ← B。 即使B指向A，断开A指向B
   3）继续向上一层传递头节点，用于最终返回结果
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode root = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return root;
    }
}


/*
创建新链表：
1、不改变原链表指针方向，遍历链表节点时，根据节点值创建新的节点，并赋值下一个节点的引用
2、root表示新链表的头指针，新节点创建完成后，root指针指向新节点，继续创建和连接节点
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode root = null;
        for (; head != null; head = head.next) {
            root = new ListNode(head.val, root);
        }
        return root;
    }
}


/*
逻辑同上，使用while替换for
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode root = null;
        while (head != null) {
            root = new ListNode(head.val, root);
            head = head.next;
        }
        return root;
    }
}


/*
栈：根据栈后进先出的特点，使用栈存放链表节点，弹出节点时改变节点的下一节点引用
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode root = new ListNode(0);
        ListNode temp = root;
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        while (!stack.isEmpty()) {
            temp.next = stack.pop();
            temp = temp.next;
        }
        temp.next = null;
        return root.next;
    }
}


/*
插入：遍历节点，将节点拿出来重新构造新的链表，每次节点都插入到新链表的头部，最终实现反转链表
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode root = new ListNode(0);
        ListNode temp = head;
        while (head != null) {
            head = head.next;
            temp.next = root.next;
            root.next = temp;
            temp = head;
        }
        return root.next;
    }
}