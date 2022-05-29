# 层次遍历，添加每一层的最后一个值
class Solution(object):
    def rightSideView(self, root):
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
            res.append(cur_val[-1])
            cur_level, next_level, cur_val = next_level, [], []
        return res