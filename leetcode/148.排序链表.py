# 将链表的值存放在数组中，数组排序后，再将值转化为链表
class Solution(object):
    def sortList(self, head):
        if not head:
            return
        res = []
        while head:
            res.append(head.val)
            head = head.next
        res.sort()
        head = ListNode(res[0])
        tmp = head
        for node in res[1:]:
            head.next = ListNode(node)
            head = head.next
        return tmp