class Solution(object):
    def subtreeWithAllDeepest(self, root):
        # 判断左右子树深度是否相同，若相同则根结点为所求
        res = self.depth(root.left) - self.depth(root.right)
        if res == 0:
            return root
        elif res > 0:
            return self.subtreeWithAllDeepest(root.left)
        else:
            return self.subtreeWithAllDeepest(root.right)
    # 求树的深度
    def depth(self, root):
        if not root:
            return 0
        return 1 + max(self.depth(root.left), self.depth(root.right))