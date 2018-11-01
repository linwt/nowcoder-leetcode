# 用数组存放链表结点值，如果重复了则该结点就是入口结点
class Solution:
    def EntryNodeOfLoop(self, pHead):
        l = []
        while pHead:
            if pHead in l:
                return pHead
            l.append(pHead)
            pHead = pHead.next