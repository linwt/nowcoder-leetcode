class Solution(object):
    def mergeTwoLists(self, l1, l2):
        # 一个链表为空则返回另一个链表
        if not l1 or not l2:
            return l1 or l2
        # 新链表的头结点
        head = cur = ListNode(0)
        while l1 and l2:
            if l1.val < l2.val:
                cur.next = l1
                l1 = l1.next
            else:
                cur.next = l2
                l2 = l2.next
            cur = cur.next
        # 其中一个链表先结束时，将另一个链表剩余部分连接到新链表
        cur.next = l1 if l1 else l2
        return head.next
