# 方法一：插入列表
class Solution:
    def printListFromTailToHead(self, listNode):
        l = []
        head = listNode
        while head:
            l.insert(0, head.val)
            head = head.next
        return l

        # while head:
        #     l.insert(head.val)
        #     head = head.next
        # return l[::-1]

        # while head:
        #     l.insert(head.val)
        #     head = head.next
        # l.reverse()
        # return l

# 方法二：递归
# 递归处理步骤：
# 1、明确方法的作用
# 2、明确递归终止条件
# 3、给出终止时处理方法
# 4、提取重复逻辑，调用自身解决相同问题
class Solution:
    # 方法的作用：返回[listNode.next.val, listNode.val]
    def printListFromTailToHead(self, listNode):
        # 终止条件
        if not listNode:
            # 处理方法
            return []
        # 提取重复逻辑，调用自身解决相同的问题
        return self.printListFromTailToHead(listNode.next) + [listNode.val]