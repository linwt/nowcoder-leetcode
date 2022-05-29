class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

# 方法一：转为字符串，相加后再转为链表
class Solution(object):
    def addTwoNumbers(self, l1, l2):
        if not l1:
            return l2
        if not l2:
            return l1
        s1, s2 = '', ''
        while l1:
            s1 += str(l1.val)
            l1 = l1.next
        while l2:
            s2 += str(l2.val)
            l2 = l2.next
        s = str(int(s1[::-1]) + int(s2[::-1]))[::-1]
        l3 = ListNode(int(s[0]))
        l = l3
        for i in s[1:]:
            l3.next = ListNode(int(i))
            l3 = l3.next
        return l

# 方法二：使用递归，每次相加一位
class Solution(object):
    def addTwoNumbers(self, l1, l2):
        if not l1:
            return l2
        if not l2:
            return l1
        if l1.val + l2.val < 10:
            l = ListNode(l1.val+l2.val)
            l.next = self.addTwoNumbers(l1.next, l2.next)
        else:
            l = ListNode(l1.val+l2.val-10)
            temp = ListNode(1)
            temp.next = None
            l.next = self.addTwoNumbers(l1.next, self.addTwoNumbers(l2.next, temp))
        return l