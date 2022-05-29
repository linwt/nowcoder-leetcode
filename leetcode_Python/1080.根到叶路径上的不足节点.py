class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    # 方法返回当前节点是否要删除
    def dfs(self, node, sums, limit):
        # 递归终止条件
        if not node.left and not node.right:
            return node.val + sums < limit
        # 默认左右子树都需要删除，后面如果左右节点为空时才能处理
        l_tree_del, r_tree_del = True, True
        # 递归判断左右子树是否需要删除
        if node.left:
            l_tree_del = self.dfs(node.left, node.val + sums, limit)
        if node.right:
            r_tree_del = self.dfs(node.right, node.val + sums, limit)
        # 需要删除则置位空
        if l_tree_del:
            node.left = None
        if r_tree_del:
            node.right = None
        # 左右子树都需要删除时，当前节点就需要删除
        return l_tree_del and r_tree_del

    def sufficientSubset(self, root, limit):
        root_del = self.dfs(root, 0, limit)
        if root_del:
            return None
        return root