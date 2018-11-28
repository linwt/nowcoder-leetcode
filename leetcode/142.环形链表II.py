# 方法一：用字典存放结点，遍历链表，若结点出现在字典中则为入环第一个结点
class Solution(object):
    def detectCycle(self, head):
        d = dict()
        while head:
            if head in d:
                return head
            d[head] = 1
            head = head.next
        return

# 方法二
class Solution(object):
    def detectCycle(self, head):
        # 用快慢指针移动，由于步数差一倍，若两指针相遇，则有环
        fast = slow = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                break
        else:
            return
        # 假设head到环的距离为A，快慢指针相遇时慢指针离入环结点走的距离为B，假设环的长度为L。
        # 则慢指针共走了A+B，快指针走了2A+2B，由于快指针比慢指针多了一圈，可表示为A+B，则2A+2B=L+A+B，即L=A+B
        # 故head指针和slow指针到入环结点的距离相等
        while head != slow:
            slow = slow.next
            head = head.next
        return head