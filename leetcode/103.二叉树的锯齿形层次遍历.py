# 层次遍历，偶数层时该层的值列表反转
class Solution(object):
    def zigzagLevelOrder(self, root):
        if not root:
            return []
        res, cur_level, next_level, cur_val = [], [root], [], []
        flag = False
        while cur_level:
            for node in cur_level:
                cur_val.append(node.val)
                if node.left:
                    next_level.append(node.left)
                if node.right:
                    next_level.append(node.right)
            if flag:
                cur_val = cur_val[::-1]
            res.append(cur_val)
            flag = not flag
            cur_level, next_level, cur_val = next_level, [], []
        return res