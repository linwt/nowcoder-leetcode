# 将索引为偶数的值累加
class Solution(object):
    def arrayPairSum(self, nums):
        nums.sort()
        return sum(nums[::2])