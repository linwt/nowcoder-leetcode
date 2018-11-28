# 写法一：递归累加求出每个结点的深度
class Solution(object):
    def minDepth(self, root):
        if not root:
            return 0
        if root.left and root.right:
            return 1 + min(self.minDepth(root.left), self.minDepth(root.right))
        elif root.left:
            return 1 + self.minDepth(root.left)
        elif root.right:
            return 1 + self.minDepth(root.right)
        else:
            return 1

# 写法二
class Solution(object):
    def minDepth(self, root):
        if not root:
            return 0
        depth = map(self.minDepth, (root.left, root.right))
        # 如果一个子树的深度为0，则取另一个子树为最小深度。如果两个子树深度都不为0，则取较小者为最小深度。
        return 1 + (min(depth) or max(depth))