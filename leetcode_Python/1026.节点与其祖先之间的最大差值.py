# 递归时计算与当前祖先里面的最大值、最小值的差值，即可算出当前节点的最大差值
# 而一颗树的祖先差值为左子树的祖先差值、右子树的祖先差值、当前节点的祖先差值三者里面的最大值
class Solution(object):
    def maxAncestorDiff(self, root):
        return self.dfs(root, root.val, root.val)

    def dfs(self, root, minVal, maxVal):
        if not root:
            return 0
        val = root.val
        root_res = max(abs(minVal - val), abs(maxVal - val))
        left_res = self.dfs(root.left, min(val, minVal), max(val, maxVal))
        right_res = self.dfs(root.right, min(val, minVal), max(val, maxVal))
        return max(root_res, left_res, right_res)