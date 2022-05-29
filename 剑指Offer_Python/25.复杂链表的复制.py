class RandomListNode:
    def __init__(self, x):
        self.label = x
        self.next = None
        self.random = None
class Solution:
    # 返回 RandomListNode
    def Clone(self, pHead):
        if not pHead:
            return
        # 新建随机结点
        newNode = RandomListNode(pHead.label)
        # 随机结点指向
        newNode.random = pHead.random
        # 下一结点指向。由于旧链表下一结点需要同样的操作，使用递归
        newNode.next = self.Clone(pHead.next)
        return newNode