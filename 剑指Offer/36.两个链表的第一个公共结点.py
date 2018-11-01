# 方法一：用数组存放一个链表结点值，遍历另一个链表判断是否有结点值在该数组中
class Solution:
    def FindFirstCommonNode(self, pHead1, pHead2):
        l = []
        while pHead1:
            l.append(pHead1)
            pHead1 = pHead1.next
        while pHead2:
            if pHead2 in l:
                return pHead2
            pHead2 = pHead2.next

# 方法二：用两个指针扫描连个链表，最终两个指针到达 null 或者到达公共结点
class Solution:
    def FindFirstCommonNode(self, pHead1, pHead2):
        p1 = pHead1
        p2 = pHead2
        while p1 != p2:
            p1 = p1.next if p1 != None else pHead2
            p2 = p2.next if p2 != None else pHead1
        return p1

        # while p1 != p2:
        #    p1 = p1.next if p1 else pHead2
        #    p2 = p2.next if p2 else pHead1
        # return p1