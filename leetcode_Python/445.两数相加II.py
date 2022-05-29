# 将链表转化为整型，相加后将结果转化为链表
class Solution(object):
    def addTwoNumbers(self, l1, l2):
        s1 = s2 = ''
        while l1:
            s1 += str(l1.val)
            l1 = l1.next
        while l2:
            s2 += str(l2.val)
            l2 = l2.next
        s3 = str(int(s1) + int(s2))
        res = head = ListNode(int(s3[0]))
        for i in s3[1:]:
            head.next = ListNode(int(i))
            head = head.next
        return res