# 递归
class Solution:
    # 方法作用：比较两个节点的值，合并较小者到链表
    def Merge(self, pHead1, pHead2):
        head = None
        # 终止条件是一个链表为空，处理方法是返回另一个链表
        if not pHead1:
            return pHead2
        if not pHead2:
            return pHead1
        else:
            if pHead1.val <= pHead2.val:
                head = pHead1
                # 提取重复逻辑
                head.next = self.Merge(pHead1.next, pHead2)
            else:
                head = pHead2
                head.next = self.Merge(pHead1, pHead2.next)
        return head
   

class Solution:
    def Merge(self, pHead1, pHead2):
        p = q = ListNode(None)
        while pHead1 and pHead2:
            if pHead1.val < pHead2.val:
                p.next = pHead1
                pHead1 = pHead1.next
            else:
                p.next = pHead2
                pHead2 = pHead2.next
            p = p.next
        p.next = pHead1 or pHead2
        return q.next
