# 判断左右子树对称的两个结点是否相同
# 嵌套方法写法
class Solution(object):
    def isSymmetric(self, root):
        def isSameTree(p, q):
            if not p and not q:
                return True
            if p and q and p.val==q.val:
                l = isSameTree(p.left, q.right)
                r = isSameTree(p.right, q.left)
                return l and r
            else:
                return False
        if not root:
            return True
        return isSameTree(root.left, root.right)

# 单独调用写法
class Solution:
    def isSymmetrical(self, pRoot):
        if not pRoot:
            return True
        return self.isSameTree(pRoot.left, pRoot.right)

    def isSameTree(self, p, q):
        if not p and not q:
            return True
        if p and q and p.val==q.val:
            l = self.isSameTree(p.left, q.right)
            r = self.isSameTree(p.right, q.left)
            return l and r
        return False

    # def isSameTree(p, q):
    #     if not p and not q:
    #         return True
    #     if (p and not q) or (not p and q):
    #         return False
    #     return p.val == q.val and isSameTree(p.left, q.right) and isSameTree(p.right, q.left)