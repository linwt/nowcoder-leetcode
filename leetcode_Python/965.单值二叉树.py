# 前序遍历获取所有节点值，判断求和结果是否与第一个值的n倍相同
class Solution(object):
    def isUnivalTree(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        self.res = []
        def preOrder(root):
            if root:
                self.res.append(root.val)
                preOrder(root.left)
                preOrder(root.right)
        preOrder(root)
        return sum(self.res) == self.res[0]*len(self.res)

# 递归判断，如果结点与左右结点值不相等，则返回false，否则返回true
class Solution2(object):
    def isUnivalTree(self, root):
        if root:
            if (root.left and root.val != root.left.val) or (root.right and root.val != root.right.val):
                return False
            return self.isUnivalTree(root.left) and self.isUnivalTree(root.right)
        return True