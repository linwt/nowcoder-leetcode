# 根左右
class Solution(object):
    def __init__(self):
        self.res = []
    def preorderTraversal(self, root):
        if root != None:
            self.res.append(root.val)
            self.preorderTraversal(root.left)
            self.preorderTraversal(root.right)
        return self.res