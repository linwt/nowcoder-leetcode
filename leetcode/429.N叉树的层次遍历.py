# cur_level：存放当前行结点
# next_level：存放下一行结点
# cur_val：存放当前行的值
# res：存放所有行的值
class Solution(object):
    def levelOrder(self, root):
        if not root:
            return []
        res, cur_level, next_level, cur_val = [], [root], [], []
        while cur_level:
            for node in cur_level:
                cur_val.append(node.val)
                for child in node.children:
                    next_level.append(child)
            res.append(cur_val)
            cur_level, next_level, cur_val = next_level, [], []
        return res