# pre指向已反序的最后一个结点，pHead指向正在反序的结点，after指向下一个要反序的结点
class Solution:
    def ReverseList(self, pHead):
        if not pHead or not pHead.next:
            return pHead
        pre, after = None, None
        while pHead:
            after = pHead.next
            pHead.next = pre
            pre = pHead
            pHead = after
        return pre