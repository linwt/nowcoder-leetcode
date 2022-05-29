# 列表第一个值构造为根结点，比根结点小的值作为左子树，比根结点大的值作为右子树，递归构造结点成二叉树
class Solution(object):
    def bstFromPreorder(self, preorder):
        if not preorder:
            return None
        root = TreeNode(preorder[0])
        left, right = [], []
        for num in preorder[1:]:
            if num < preorder[0]:
                left.append(num)
            else:
                right.append(num)
        root.left = self.bstFromPreorder(left)
        root.right = self.bstFromPreorder(right)
        return root