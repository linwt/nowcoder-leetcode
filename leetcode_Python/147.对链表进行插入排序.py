class Solution(object):
    def insertionSortList(self, head):
        if not head or not head.next:
            return head

        h = ListNode(-1)
        h.next = head
        pre = h
        cur = head
        while cur:
            lat = cur.next
            # 下一个结点值比当前小
            if lat and lat.val < cur.val:
                # 从头开始遍历，找到第一个比待插入结点大的结点
                while pre.next and pre.next.val < lat.val:
                    pre = pre.next
                # 将结点插入到它的前面
                big = pre.next
                pre.next = lat
                cur.next = lat.next
                lat.next = big
                # 指针再次指向头结点，便于下个结点排序遍历
                pre = h
            else:
                cur = lat

        return h.next