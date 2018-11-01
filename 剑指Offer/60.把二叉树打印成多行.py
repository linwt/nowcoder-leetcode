# cur_list：存放当前行结点
# next_list：存放下一行结点
# level：存放当前行的值
# res：存放所有行的值
class Solution:
    # 返回二维列表[[1,2],[4,5]]
    def Print(self, pRoot):
        if not pRoot:
            return []
        cur_list, next_list, level, res = [pRoot], [], [], []
        while cur_list:
            for i in cur_list:
                level.append(i.val)
                if i.left:
                    next_list.append(i.left)
                if i.right:
                    next_list.append(i.right)
            res.append(level)
            cur_list, next_list, level = next_list, [], []
        return res