# 方法作用极简化：将两个结点的值求和作为新结点并返回。递归后变成合并两棵树
class Solution(object):
    def mergeTrees(self, t1, t2):
        if not t1 and not t2:
            return
        if not t1 or not t2:
            return t1 or t2
        root = TreeNode(t1.val + t2.val)
        root.left = self.mergeTrees(t1.left, t2.left)
        root.right = self.mergeTrees(t1.right, t2.right)
        return root