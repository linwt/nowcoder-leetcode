# 方法一：使用快慢指针，若指针相遇，则有环
class Solution(object):
    def hasCycle(self, head):
        fast = slow = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                return True
        return False

# 方法二：使用字典存放访问过的结点
class Solution(object):
    def hasCycle(self, head):
        d = dict()
        while head:
            if head in d:
                return True
            d[head] = 1
            head = head.next
        return False