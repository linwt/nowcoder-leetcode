class Solution:
    def TreeDepth(self, pRoot):
        # 无结点的情况
        if not pRoot:
            return 0
        # 1到多个结点的情况
        return 1 + max(self.TreeDepth(pRoot.left), self.TreeDepth(pRoot.right))