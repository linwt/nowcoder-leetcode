class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


# 深度优先搜索，从下往上计算深度，比较左右子树的深度，最近公共祖先的左右子树等高
class Solution(object):
    def lcaDeepestLeaves(self, root):
        def dfs(root):
            if not root:
                return None, 0
            l_node, l_depth = dfs(root.left)
            r_node, r_depth = dfs(root.right)
            if l_depth > r_depth:
                return l_node, l_depth + 1
            elif l_depth < r_depth:
                return r_node, r_depth + 1
            else:
                return root, l_depth + 1

        node, _ = dfs(root)
        return node