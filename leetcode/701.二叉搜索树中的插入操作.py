class Solution(object):
    def insertIntoBST(self, root, val):
        if not root:
            return TreeNode(val)
        if val < root.val:
            root.left = self.insertIntoBST(root.left, val)
        if val > root.val:
            root.right = self.insertIntoBST(root.right, val)
        return root

################## 递归思路 #################
# 方法作用极简化：先判断无结点和1个结点的情况
# 方法作用描述：参数给一个根和值，将该值的结点插入到根的左右孩子，然后返回插入后的根结点
# 递归：由于左右孩子有同样需求，给定值结点部分使用递归得到插入后的根结点，将返回结果赋给根结点的左右孩子
class Solution(object):
    def insertIntoBST(self, root, val):
        if not root:
            return TreeNode(val)
        if val < root.val:
            root.left = TreeNode(val)
        if val > root.val:
            root.right = TreeNode(val)
        return root