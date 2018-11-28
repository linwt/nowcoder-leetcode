# 两个结点在根结点两边则共同祖先是root，在同一边则递归判断
class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        if not root:
            return
        if root.val > p.val and root.val > q.val:
            return self.lowestCommonAncestor(root.left, p, q)
        if root.val < p.val and root.val < q.val:
            return self.lowestCommonAncestor(root.right, p, q)
        return root