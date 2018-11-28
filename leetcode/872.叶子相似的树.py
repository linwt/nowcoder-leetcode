# 获取叶值序列进行比较
class Solution(object):
    def leafSimilar(self, root1, root2):
        def findLeaf(root):
            if not root:
                return []
            if not root.left and not root.right:
                return [root.val]
            return findLeaf(root.left) + findLeaf(root.right)

        return findLeaf(root1) == findLeaf(root2)

