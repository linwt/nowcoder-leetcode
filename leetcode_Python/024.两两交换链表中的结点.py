# 递归
class Solution(object):
    def swapPairs(self, head):
        if not head or not head.next:
            return head
        lat = head.next
        head.next = self.swapPairs(lat.next)
        lat.next = head
        return lat

############## 递归思路 ###################
# 方法作用极简化：先考虑无、1、2个结点的情况。
# 方法作用描述：参数给一个头结点，两个结点交换后，返回新的头结点。由于剩余部分需要同样操作，使用递归
class Solution(object):
    def swapPairs(self, head):
        if not head or not head.next:
            return head
        lat = head.next
        head.next = None
        lat.next = head
        return lat