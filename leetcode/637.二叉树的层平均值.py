# 获取每层的值后求平均
class Solution(object):
    def averageOfLevels(self, root):
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
            res.append(float(sum(cur_val))/float(len(cur_val)))
            cur_level, next_level, cur_val = next_level, [], []
        return res