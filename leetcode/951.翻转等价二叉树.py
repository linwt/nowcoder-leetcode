# 根结点必须相等，子结点左左且右右相等或左右且右左相等
class Solution(object):
    def flipEquiv(self, root1, root2):
        if not root1 and not root2:
            return True
        if root1 and root2 and root1.val == root2.val:
            return (self.flipEquiv(root1.left, root2.right) and self.flipEquiv(root1.right, root2.left)) \
                   or (self.flipEquiv(root1.left, root2.left) and self.flipEquiv(root1.right, root2.right))
        return False