# 中序遍历后数组相邻值之差取最小
class Solution(object):
    def minDiffInBST(self, root):
        self.res = []
        ans = 999
        def midOrder(root):
            if root:
                midOrder(root.left)
                self.res.append(root.val)
                midOrder(root.right)
        midOrder(root)
        for i in range(len(self.res)-1):
            ans = min(ans, self.res[i+1] - self.res[i])
        return ans