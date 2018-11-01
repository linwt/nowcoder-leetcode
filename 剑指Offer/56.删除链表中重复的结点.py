# 用数组存放结点值，再统计结点个数，将个数为1的结点链接成链表
class Solution:
    def deleteDuplication(self, pHead):
        l = []
        while pHead:
            l.append(pHead.val)
            pHead = pHead.next
        res = ListNode(None)
        head = res
        for i in l:
            if l.count(i)==1:
                head.next = ListNode(i)
                head = head.next
        return res.next