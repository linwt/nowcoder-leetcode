# 方法一：递归
class Solution(object):
    def postorder(self, root):
        res = []
        if root:
            for child in root.children:
                res += self.postorder(child)
            res.append(root.val)
        return res

# 方法二：迭代
class Solution(object):
    def postorder(self, root):
        if not root:
            return []
        res, stack = [], [root]
        while stack:
            node = stack.pop()
            res.append(node.val)
            for child in node.children:
                stack.append(child)
        return res[::-1]