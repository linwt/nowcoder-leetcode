# 方法作用极简化为有结点则返回1，递归累加后得到深度
class Solution(object):
    def maxDepth(self, root):
        # 无结点的情况
        if not root:
            return 0
        # 1到多个结点的情况
        return max(self.maxDepth(root.left), self.maxDepth(root.right)) + 1