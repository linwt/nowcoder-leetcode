class Solution(object):
    def generateTrees(self, n):
        if n == 0:
            return []
        return self.constructTrees(1, n)

    def constructTrees(self, start, end):
        if start > end:
            return [None]
        res = []
        for i in range(start, end+1):
            lefts = self.constructTrees(start, i-1)
            rights = self.constructTrees(i+1, end)
            for left in lefts:
                for right in rights:
                    root = TreeNode(i)
                    root.left = left
                    root.right = right
                    res.append(root)
        return res

################# 递归思路 #################
# 方法作用极简化：先判断一个结点的情况
# 方法作用描述：将给定起止范围的值转为结点添加到数组中，并返回该数组
def constructTrees(self, start, end):
    # 没有合适的范围，返回空结点
    if start > end:
        return [None]
    res = []
    for i in range(start, end+1):
        root = TreeNode(i)
        res.append(root)
    return res