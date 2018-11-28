# 方法一：在原链表上复制结点，新结点在旧结点之后
class Solution(object):
    def copyRandomList(self, head):
        # 复制结点
        h = head
        while h:
            new = RandomListNode(h.label)
            new.next = h.next
            h.next = new
            h = new.next
        # 复制随机指针
        h = head
        while h:
            if h.random:
                h.next.random = h.random.next
            h = h.next.next
        # 获取新链表
        res = copy = RandomListNode(0)
        while head:
            copy.next = head.next
            copy = copy.next
            head.next = head.next.next
            head = head.next
        return res.next

# 方法二：使用字典复制结点，key：旧结点，value：新结点
class Solution(object):
    def copyRandomList(self, head):
        if not head:
            return
        d = dict()
        # 复制结点
        h = head
        while h:
            d[h] = RandomListNode(h.label)
            h = h.next
        # 随机指针可能为空
        d[None] = None
        # 复制随机指针
        h = head
        while h:
            d[h].next = d[h.next]
            d[h].random = d[h.random]
            h = h.next
        # 返回新链表
        return d[head]