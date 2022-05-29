# 如果head有child，则child为头结点的链表尾结点与head.next互连，然后head跟child互连。
class Solution(object):
    def flatten(self, head):
        if not head:
            return head
        s = Node(None, None, head, None)
        while head:
            if head.child:
                child = head.child
                child.prev = head
                while child.next:
                    child = child.next
                child.next = head.next
                if head.next:
                    head.next.prev = child
                head.next = head.child
                head.child = None
            head = head.next
        return s.next