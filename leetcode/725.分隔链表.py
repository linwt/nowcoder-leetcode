class Solution(object):
    def splitListToParts(self, root, k):
        # 计算链表长度
        count = 0
        head = root
        while head:
            count += 1
            head = head.next

        # nums代表每组的长度，rem代表前面几组可以再加1个结点
        nums = count/k
        rem = count%k
        res = []
        for _ in range(k):
            head = h = ListNode(0)
            for _ in range(nums):
                head.next = ListNode(root.val)
                head = head.next
                root = root.next
            if rem:
                head.next = ListNode(root.val)
                root = root.next
                rem -= 1
            res.append(h.next)
        return res