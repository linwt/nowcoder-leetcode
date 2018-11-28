# 与563题相似
# 方法一
class Solution(object):
    def diameterOfBinaryTree(self, root):
        if not root:
            return 0
        # 对每一个结点求直径，得到长度最大的直径
        return max(self.maxDepth(root.left) + self.maxDepth(root.right), self.diameterOfBinaryTree(root.left), self.diameterOfBinaryTree(root.right))

    # 求某结点为根时，该树的最大深度
    def maxDepth(self, root):
        if not root:
            return 0
        return 1 + max(self.maxDepth(root.left), self.maxDepth(root.right))

# 方法二：边求深度，边更新res的值
class Solution(object):
    def diameterOfBinaryTree(self, root):
        self.res = 0
        def maxDepth(root):
            if not root:
                return 0
            L = maxDepth(root.left)
            R = maxDepth(root.right)
            self.res = max(self.res, L+R)
            return 1 + max(L, R)
        maxDepth(root)
        return self.res