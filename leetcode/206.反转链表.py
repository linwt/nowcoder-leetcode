# 方法一：使用三个指针分别指向前一个、当前、下一个结点
class Solution(object):
    def reverseList(self, head):
        before = None
        while head:
            after = head.next
            head.next = before
            before = head
            head = after
        return before

# 方法二：递归
class Solution(object):
    def reverseList(self, head):

        def reverse(head, before):
            if head:
                after = head.next
                head.next = before
                return reverse(after, head)
            return before

        return reverse(head, None)