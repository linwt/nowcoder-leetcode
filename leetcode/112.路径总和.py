class Solution(object):
    def hasPathSum(self, root, sum):
        if not root:
            return False
        return (not root.left and not root.right and root.val == sum) \
               or self.hasPathSum(root.left, sum-root.val) \
               or self.hasPathSum(root.right, sum-root.val)

################ 递归思路 ################
# 方法作用极简化：先判断无结点和1个结点的情况。返回结点与给定值是否相等的判断
# 由于其他结点需要同样操作，使用递归
class Solution(object):
    def hasPathSum(self, root, sum):
        if not root:
            return False
        return root.val == sum