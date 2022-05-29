# 值相同则将next指针指向下下位，重复判断每个结点
class Solution(object):
    def deleteDuplicates(self, head):
        res = head
        while head:
            while head.next and head.val == head.next.val:
                head.next = head.next.next
            head = head.next
        return res