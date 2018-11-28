class Solution(object):
    def isSubtree(self, s, t):
        if not t:
            return True
        if not s and t:
            return False
        # 判断不同结点作为根结点的树是否与给定树相同
        return self.isSametree(s, t) or self.isSubtree(s.left, t) or self.isSubtree(s.right, t)

    # 方法作用：判断给定的两个结点是否相同。递归后变成判断两棵树是否相同
    def isSametree(self, p, q):
        if not p and not q:
            return True
        if (not p and q) or (p and not q):
            return False
        return p.val==q.val and self.isSametree(p.left, q.left) and self.isSametree(p.right, q.right)