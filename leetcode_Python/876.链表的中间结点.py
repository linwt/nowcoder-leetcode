# 方法一：用数组存放结点值，返回中间结点后面的值
class Solution(object):
    def middleNode(self, head):
        res = []
        while head:
            res.append(head.val)
            head = head.next
        return res[len(res)/2:]

# 方法二：快的比慢的快一倍，当快的到底时，慢的刚好在中间
class Solution(object):
    def middleNode(self, head):
        fast = slow = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        return slow