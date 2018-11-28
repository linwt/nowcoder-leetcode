# 层次遍历，res数组添加每一行的最大值
class Solution(object):
    def largestValues(self, root):
        if not root:
            return []
        res, cur_level, next_level, cur_val = [], [root], [], []
        while cur_level:
            for node in cur_level:
                cur_val.append(node.val)
                if node.left:
                    next_level.append(node.left)
                if node.right:
                    next_level.append(node.right)
            res.append(max(cur_val))
            cur_level, next_level, cur_val = next_level, [], []
        return res