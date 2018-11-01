class Solution:
    # 方法作用极简化：判断一个结点的值与给定值是否相同，相同则返回该值
    def FindPath(self, root, expectNumber):
        # 无的情况
        if not root:
            return []
        # 1个结点的情况
        if not root.left and not root.right and root.val==expectNumber:
            return [[root.val]]
        # 2或3个结点的情况，由此类推到多的情况
        left = self.FindPath(root.left, expectNumber-root.val)
        right = self.FindPath(root.right, expectNumber-root.val)
        res = []
        for i in left+right:
            res.append([root.val] + i)
        return res