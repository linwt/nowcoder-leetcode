# 方法一：将倒数k个结点移到前面。使用数组存放结点值，位置移动后再转为链表
class Solution(object):
    def rotateRight(self, head, k):
        if not head:
            return
        res = []
        while head:
            res.append(head.val)
            head = head.next
        K = k%len(res)
        res = res[-K:] + res[:-K]
        head = h = ListNode(None)
        for i in res:
            head.next = ListNode(i)
            head = head.next
        return h.next

# 方法二：将链表首尾连接成环，再根据要求确定新的头结点，断开环
class Solution(object):
    def rotateRight(self, head, k):
        if not head or not head.next:
            return head

        h = head
        length = 1
        while h.next:
            length += 1
            h = h.next

        h.next = head
        step = length - k%length

        for _ in range(step):
            h = h.next
        res = h.next
        h.next = None
        return res