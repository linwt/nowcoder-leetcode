class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        # 找p、q结点，找到则返回该结点
        if not root or root==p or root==q:
            return root
        # 在左子树找p、q结点
        left = self.lowestCommonAncestor(root.left, p, q)
        # 在右子树找p、q结点
        right = self.lowestCommonAncestor(root.right, p, q)
        # p、q结点分别在左子树和右子树，最近公共祖先就是根
        if left and right:
            return root
        # p、q结点同时在左子树或右子树
        return left or right