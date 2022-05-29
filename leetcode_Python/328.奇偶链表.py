# 依赖next指针，奇偶位置的结点交替连接，最后奇偶链连接
class Solution(object):
    def oddEvenList(self, head):
        if not head:
            return head
        odd, even, evenHead = head, head.next, head.next
        while even and even.next:
            odd.next = even.next
            odd = odd.next
            even.next = odd.next
            even = even.next
        odd.next = evenHead
        return head