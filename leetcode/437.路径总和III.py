class Solution(object):
    def pathSum(self, root, sum):
        if not root:
            return 0
        return self.dfs(root, sum) + self.pathSum(root.left, sum) + self.pathSum(root.right, sum)

    # 计算某结点开始符合的路径数
    def dfs(self, root, sum):
        res = 0
        if not root:
            return res
        if root.val==sum:
            res += 1
        res += self.dfs(root.left, sum-root.val)
        res += self.dfs(root.right, sum-root.val)
        return res