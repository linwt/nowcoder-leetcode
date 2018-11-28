# 中序遍历，当前结点值加上其后面结点值的和
class Solution(object):
    def convertBST(self, root):
        def inorder(root):
            if not root:
                return []
            return inorder(root.left) + [root] + inorder(root.right)

        nodes = inorder(root)
        values = [node.val for node in nodes]
        bigSum = sum(values)
        for i in range(len(values)):
            bigSum -= values[i]
            nodes[i].val = values[i] + bigSum
        return root