# 方法一：将所有链表结点存放在数组中，排序后再转化为链表
class Solution(object):
    def mergeKLists(self, lists):
        res = []
        for l in lists:
            while l:
                res.append(l.val)
                l = l.next
        res.sort()
        head = h = ListNode(None)
        for i in res:
            h.next = ListNode(i)
            h = h.next
        return head.next

# 方法二：将每个链表的一个结点放入数组，使用最小堆弹出最小结点，再存入新结点比较
class Solution(object):
    def mergeKLists(self, lists):
        import heapq
        res = cur = ListNode(-1)
        q = []
        # 各链表的头结点
        for head in lists:
            if head:
                heapq.heappush(q, (head.val, head))
        # 弹出最小结点，若该结点还有下一个结点，则将下一个结点存入数组
        while q:
            cur.next = heapq.heappop(q)[1]
            cur = cur.next
            if cur.next:
                heapq.heappush(q, (cur.next.val, cur.next))

        return res.next