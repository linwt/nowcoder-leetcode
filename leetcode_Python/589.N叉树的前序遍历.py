# 方法一：递归
class Solution(object):

    def preorder(self, root):
        res = []
        if root:
            res.append(root.val)
            for child in root.children:
                res += self.preorder(child)
        return res

# 方法二:迭代
class Solution(object):
    def preorder(self, root):
        if not root:
            return []
        res, stack = [], [root]
        while stack:
            node = stack.pop()
            res.append(node.val)
            for child in node.children[::-1]:
                stack.append(child)
        return res