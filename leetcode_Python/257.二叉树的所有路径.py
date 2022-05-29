# 递归添加结点，到达叶结点时将该路径添加到res数组中
class Solution(object):
    def binaryTreePaths(self, root):

        def findPath(node, cur_path):
            if not node:
                return []
            if not node.left and not node.right:
                res.append(cur_path + [node.val])
                return
            if node.left:
                findPath(node.left, cur_path + [node.val])
            if node.right:
                findPath(node.right, cur_path + [node.val])

        res = []
        if not root:
            return res
        findPath(root, [])
        return ['->'.join(str(val) for val in path) for path in res]