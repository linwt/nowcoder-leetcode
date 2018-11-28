class Solution(object):
    # 方法作用极简化：由前序和中序序列得到根结点，并返回根。左右子树有同样需求使用递归
    def buildTree(self, preorder, inorder):
        if not preorder and not inorder:
            return
        root = TreeNode(preorder[0])
        index = inorder.index(preorder[0])
        root.left = self.buildTree(preorder[1:index+1], inorder[:index])
        root.right = self.buildTree(preorder[index+1:], inorder[index+1:])
        return root