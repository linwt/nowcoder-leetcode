# 左根右，方法的作用是将结点添加到数组，需要此功能则递归
class Solution(object):
    def __init__(self):
        self.res = []
    def inorderTraversal(self, root):
        if root:
            self.inorderTraversal(root.left)
            self.res.append(root.val)
            self.inorderTraversal(root.right)
        return self.res