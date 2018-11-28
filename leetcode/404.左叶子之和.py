# 对于左孩子，判断是否为叶子结点，是则加上该值，不是则递归。对于右孩子，直接递归
class Solution(object):
    def sumOfLeftLeaves(self, root):
        # 判断是否为叶子
        def isLeaf(node):
            if not node:
                return False
            if not node.left and not node.right:
                return True
            return False

        res = 0
        if root:
            if isLeaf(root.left):
                res += root.left.val
            else:
                res += self.sumOfLeftLeaves(root.left)
            res += self.sumOfLeftLeaves(root.right)
        return res