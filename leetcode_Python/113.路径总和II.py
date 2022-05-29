# 类似129题
# 搜到叶子节点判断是否符合条件，若符合条件则将记录该路径的集合添加到结果集合中
class Solution(object):

    def pathSum(self, root, sum):
        global res
        res = []
        self.dfs(root, sum, [])
        return res

    def dfs(self, root, sum, cur_list):
        if not root:
            return
        sum -= root.val
        if sum==0 and not root.left and not root.right:
            res.append(cur_list + [root.val])
        if root.left:
            self.dfs(root.left, sum, cur_list + [root.val])
        if root.right:
            self.dfs(root.right, sum, cur_list + [root.val])