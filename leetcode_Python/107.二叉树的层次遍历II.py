# 用数组存放当前层结点，下一层结点，当前层结点值，所有结点值
class Solution(object):
    def levelOrderBottom(self, root):
        if not root:
            return []
        res, next_list, level, cur_list = [], [], [], [root]
        while cur_list:
            for node in cur_list:
                level.append(node.val)
                if node.left:
                    next_list.append(node.left)
                if node.right:
                    next_list.append(node.right)
            res.append(level)
            cur_list, next_list, level = next_list, [], []
        return res[::-1]