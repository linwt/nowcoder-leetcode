# 深度优先搜索，得到所有路径表示的数字，最后转为十进制相加
class Solution(object):
    def sumRootToLeaf(self, root):
        global res
        res, sum = [], 0
        self.dfs(root, '')
        for i in res:
            sum += int(i, 2)
        return sum

    def dfs(self, root, s):
        if not root:
            return ''
        if not root.left and not root.right:
            res.append(s + str(root.val))
        if root.left:
            self.dfs(root.left, s + str(root.val))
        if root.right:
            self.dfs(root.right, s + str(root.val))