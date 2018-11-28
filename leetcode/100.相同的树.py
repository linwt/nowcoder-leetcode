# 递归判断两棵树对应位置的结点
# 方法极简化是判断两个结点是否相同，递归后变成判断两棵树是否相同
class Solution(object):
    def isSameTree(self, p, q):
        if not p and not q:
            return True
        if (p and not q) or (not p and q):
            return False
        return p.val==q.val and self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)