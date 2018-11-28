# 一条路径上累加结点个数，取最大个数
class Solution(object):
    def maxDepth(self, root):
        if not root:
            return 0
        return 1 + max([self.maxDepth(child) for child in root.children]) if root.children else 1