# 左右两边通过加减一个数求和，并判断是否相等
class Solution(object):
    def pivotIndex(self, nums):
        left, right = 0, sum(nums)
        for i, num in enumerate(nums):
            right -= num
            if left == right:
                return i
            left += num
        return -1