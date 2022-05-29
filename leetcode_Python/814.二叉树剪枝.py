class Solution(object):
    def pruneTree(self, root):
        if not root:
            return
        root.left = self.pruneTree(root.left)
        root.right = self.pruneTree(root.right)
        if not root.left and not root.right and root.val == 0:
            return
        return root

################## 递归思路 #################
# 方法作用极简化：先判断无结点和1个结点的情况
# 方法作用描述：参数给一个结点，如果结点为0则返回空，即剪掉该结点，否则返回该结点
# 递归：由于左右孩子有同样需求，使用递归，然后将返回结果赋给根结点的左右孩子
class Solution(object):
    def pruneTree(self, root):
        if not root:
            return
        if root.val == 0:
            return
        return root