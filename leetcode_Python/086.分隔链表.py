# 将<x的结点和>=x的结点分别组成新链表，再将两个链表连接
class Solution(object):
    def partition(self, head, x):
        h1 = head1 = ListNode(0)
        h2 = head2 = ListNode(0)
        while head:
            if head.val < x:
                h1.next = head
                h1 = h1.next
            else:
                h2.next = head
                h2 = h2.next
            head = head.next
        # 由于尾结点可能还连接着<x的结点，所以需要指向空
        h2.next = None
        h1.next = head2.next
        return head1.next