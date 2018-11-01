# cur_list：存放当前行结点
# next_list：存放下一行结点
# level：存放当前行的值
# res：存放所有行的值
# flag：反复判断奇偶行
class Solution:
    def Print(self, pRoot):
        if not pRoot:
            return []
        cur_list, next_list, level, res = [pRoot], [], [], []
        flag = 0
        while cur_list:
            for i in cur_list:
                level.append(i.val)
                if i.left:
                    next_list.append(i.left)
                if i.right:
                    next_list.append(i.right)
            if flag:
                flag = 0
                level.reverse()
            else:
                flag = 1
            res.append(level)
            cur_list, next_list, level = next_list, [], []
        return res