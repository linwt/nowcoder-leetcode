class Solution(object):
    def constructMaximumBinaryTree(self, nums):
        root = TreeNode(max(nums))
        index = nums.index(max(nums))
        if index > 0:
            root.left = self.constructMaximumBinaryTree(nums[:index])
        if index < len(nums)-1:
            root.right = self.constructMaximumBinaryTree(nums[index+1:])
        return root

################### 递归思路 ####################
# 方法作用极简化：判断一个结点的情况
# 方法作用描述：参数给一个数组，取该数组的最大值作为结点，并返回该结点
# 递归：根的左右孩子都需要剩余数组里的最大值作为结点，使用递归
class Solution(object):
    def constructMaximumBinaryTree(self, nums):
        root = TreeNode(max(nums))
        return root