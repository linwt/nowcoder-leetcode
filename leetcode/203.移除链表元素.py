# 若当前结点的下一结点是要删除的元素，则将当前结点的next指针指向下下个结点
# 写法一
class Solution(object):
    def removeElements(self, head, val):
        res = h = ListNode(0)
        h.next = head
        while h:
            while h.next and h.next.val == val:
                h.next = h.next.next
            h = h.next
        return res.next

# 写法二
class Solution(object):
    def removeElements(self, head, val):
        res = h = ListNode(0)
        h.next = head
        while h.next:
            if h.next.val == val:
                h.next = h.next.next
            else:
                h = h.next
        return res.next