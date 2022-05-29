# 层次遍历判断
class Solution(object):
    def isCousins(self, root, x, y):
        cur_level = [root]
        while cur_level:
            cur_val, n = [], len(cur_level)
            # 遍历当前层结点，并获取下一层结点
            for _ in range(n):
                node = cur_level.pop(0)
                if node:
                    cur_val.append(node.val)
                    cur_level.append(node.left)
                    cur_level.append(node.right)
                # 结点为空则填充0占位置
                else:
                    cur_val.append(0)
            # 两个值在同一层
            if x in cur_val and y in cur_val:
                index1, index2 = cur_val.index(x), cur_val.index(y)
                index1, index2 = sorted([index1, index2])
                # 两结点相邻且较小索引为偶数说明两节点有共同父节点
                if index2 - index1 == 1 and index1 % 2 == 0:
                    return False
                return True
            # 两个值不在同一层
            if x in cur_val or y in cur_val:
                return False
        return False