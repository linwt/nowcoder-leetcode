# 方法一：将结点值添加到数组，反转数组看是否相同
class Solution(object):
    def isPalindrome(self, head):
        res = []
        while head:
            res.append(head.val)
            head = head.next
        return res[:] == res[::-1]

# 方法二：将链表分为两半，反转后半部分链表，与前半部分链表比较是否相同
class Solution(object):
    def isPalindrome(self, head):
        fast = slow = head
        # 找到中间节点
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
        # 翻转后半部分
        before = None
        while slow:
            after = slow.next
            slow.next = before
            before = slow
            slow = after
        # 比较前后两部分
        while before:
            if before.val != head.val:
                return False
            before = before.next
            head = head.next
        return True