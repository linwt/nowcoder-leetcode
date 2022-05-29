# 方法作用极简化：由中序和后序序列得到根结点，并返回根。左右子树有同样需求使用递归
class Solution(object):
    def buildTree(self, inorder, postorder):
        if not inorder or len(inorder)==0:
            return None
        root = TreeNode(postorder[-1])
        index = inorder.index(postorder[-1])
        root.left = self.buildTree(inorder[:index], postorder[:index])
        root.right = self.buildTree(inorder[index+1:], postorder[index:-1])
        return root