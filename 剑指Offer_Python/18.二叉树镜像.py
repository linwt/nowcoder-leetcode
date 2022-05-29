class Solution:
    # 方法作用：交换左右子树
    def Mirror(self, root):
        if root:
            root.left, root.right = root.right, root.left
            self.Mirror(root.left)
            self.Mirror(root.right)