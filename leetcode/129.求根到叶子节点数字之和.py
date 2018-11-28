# 类似113题
# 深度优先搜索，得到所有路径的数组，再将每个路径组合成数字相加
class Solution(object):
    def sumNumbers(self, root):
        global res
        res = []
        self.dfs(root, [])
        sum = 0
        for path in res:
            sum += int(''.join(str(i) for i in path))
        return sum

    def dfs(self, root, cur_list):
        if not root:
            return []
        if not root.left and not root.right:
            res.append(cur_list + [root.val])
        if root.left:
            self.dfs(root.left, cur_list + [root.val])
        if root.right:
            self.dfs(root.right, cur_list + [root.val])