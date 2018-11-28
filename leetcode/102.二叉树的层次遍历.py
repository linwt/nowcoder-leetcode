# cur_list：存放当前行结点
# next_list：存放下一行结点
# level：存放当前行的值
# res：存放所有行的值
class Solution(object):
    def levelOrder(self, root):
        res, cur_list, next_list, level = [], [], [], []
        if root:
            cur_list = [root]
        while cur_list:
            while cur_list:
                temp = cur_list.pop(0)
                level.append(temp.val)
                if temp.left:
                    next_list.append(temp.left)
                if temp.right:
                    next_list.append(temp.right)
            res.append(level)
            cur_list, next_list, level = next_list, [], []
        return res

