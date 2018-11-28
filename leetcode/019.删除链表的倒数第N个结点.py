class Solution(object):
    def removeNthFromEnd(self, head, n):
        res = left = right = ListNode(0)
        res.next = head
        # 右指针先走n步
        while n:
            right = right.next
            n -= 1
        # 左右指针同时向前走，右指针到底时，左指针的下一结点为倒数第N个结点
        while right.next:
            left = left.next
            right = right.next
        left.next = left.next.next
        return res.next