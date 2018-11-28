# 层次遍历，返回最后一层第一个元素
class Solution(object):
    def findBottomLeftValue(self, root):
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
            res.append(cur_val)
            cur_level, next_level, cur_val = next_level, [], []
        return res[-1][0]