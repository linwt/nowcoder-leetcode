# 中序遍历后将给定范围的值求和
class Solution(object):
    def rangeSumBST(self, root, L, R):
        self.res = []
        def midOrder(root):
            if root:
                midOrder(root.left)
                self.res.append(root.val)
                midOrder(root.right)
        midOrder(root)
        return sum(self.res[self.res.index(L):self.res.index(R)+1])

# 遍历每个结点，若该值在范围内则累加
class Solution2(object):
    def rangeSumBST(self, root, L, R):
        self.res = 0
        def addScope(root):
            if root:
                if L <= root.val <= R:
                    self.res += root.val
                addScope(root.left)
                addScope(root.right)
        addScope(root)
        return self.res