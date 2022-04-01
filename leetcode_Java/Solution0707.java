// 707. 设计链表


/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */


/*
单链表
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

class MyLinkedList {

    int size;
    ListNode head;

    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode cur = head;
        for (int i = 0; i < index + 1; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        ListNode node = new ListNode(val);
        node.next = cur.next;
        cur.next = node;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        size--;
    }
}


/*
双链表
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode prev;
    ListNode(int val) {
        this.val = val;
    }
}

class MyLinkedList {

    int size;
    ListNode head;
    ListNode tail;

    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode cur;
        if (index + 1 < size - index) {
            cur = head;
            for (int i = 0; i < index + 1; i++) {
                cur = cur.next;
            }
        } else {
            cur = tail;
            for (int i = 0; i < size - index; i++) {
                cur = cur.prev;
            }
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        ListNode before = head, after = head.next;
        ListNode node = new ListNode(val);
        node.next = after;
        node.prev = before;
        before.next = node;
        after.prev = node;
        size++;
    }

    public void addAtTail(int val) {
        ListNode before = tail.prev, after = tail;
        ListNode node = new ListNode(val);
        node.next = after;
        node.prev = before;
        before.next = node;
        after.prev = node;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        ListNode before, after;
        if (index < size - index) {
            before = head;
            for (int i = 0; i < index; i++) {
                before = before.next;
            }
            after = before.next;
        } else {
            after = tail;
            for (int i = 0; i < size - index; i++) {
                after = after.prev;
            }
            before = after.prev;
        }
        ListNode node = new ListNode(val);
        node.next = after;
        node.prev = before;
        before.next = node;
        after.prev = node;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode before, after;
        if (index < size - index - 1) {
            before = head;
            for (int i = 0; i < index; i++) {
                before = before.next;
            }
            after = before.next.next;
        } else {
            after = tail;
            for (int i = 0; i < size - index - 1; i++) {
                after = after.prev;
            }
            before = after.prev.prev;
        }
        before.next = after;
        after.prev = before;
        size--;
    }
}
