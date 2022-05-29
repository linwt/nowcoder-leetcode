class Solution(object):
    def reverseBetween(self, head, m, n):
        if not head or not head.next:
            return head

        h = ListNode(-1)
        h.next = head
        pre = h
        cur = head
        i = 1
        # 移动到待反转部分起始点
        while i < m:
            pre = cur
            cur = cur.next
            i += 1
        # 指针记录结点位置，后面用于连接
        h1 = pre
        h2 = cur
        # 反转链表
        while i <= n:
            lat = cur.next
            cur.next = pre
            pre = cur
            cur = lat
            i += 1
        # 反转后头尾指针与原链表相接
        h1.next = pre
        h2.next = cur

        return h.next