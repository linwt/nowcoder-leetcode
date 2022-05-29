# 二叉搜索树：左子树都比根结点小，右子树都比根结点大

# 递归思路
# 1、方法作用极简化：把数组中间的值转化为结点，然后返回该结点
# 2、处理无和1个结点的情况
# 3、处理多个结点的情况，重复逻辑使用递归
class Solution(object):
    def sortedArrayToBST(self, nums):
        if not nums:
            return None
        root = TreeNode(nums[len(nums)/2])
        root.left = self.sortedArrayToBST(nums[:len(nums)/2])
        root.right = self.sortedArrayToBST(nums[len(nums)/2+1:])
        return root