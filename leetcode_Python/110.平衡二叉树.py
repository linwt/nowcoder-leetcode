class Solution(object):
    # 判断左子树和右子树的高度，并递归判断左右结点的左右子树高度
    def isBalanced(self, root):
        if not root:
            return True
        return abs(self.high(root.left) - self.high(root.right)) <= 1 and self.isBalanced(root.left) and self.isBalanced(root.right)

    # 求树的高度
    def high(self, root):
        if not root:
            return 0
        return 1 + max(self.high(root.left), self.high(root.right))