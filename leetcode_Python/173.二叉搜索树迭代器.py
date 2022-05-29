# 使用中序遍历的到的有序数组
class BSTIterator(object):
    def __init__(self, root):
        self.root = root
        self.res = []
        self.inorder(root)

    def hasNext(self):
        return self.res != []

    def next(self):
        return self.res.pop(0)

    def inorder(self, root):
        if root:
            self.inorder(root.left)
            self.res.append(root.val)
            self.inorder(root.right)