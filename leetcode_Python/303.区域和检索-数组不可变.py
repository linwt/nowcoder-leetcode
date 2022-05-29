# 方法一：数组切片
class NumArray(object):

    def __init__(self, nums):
        self.nums = nums

    def sumRange(self, i, j):
        return sum(self.nums[i:j+1])

# 方法二：数组内先求和
class NumArray(object):

    def __init__(self, nums):
        self.nums = nums
        for i in range(1, len(nums)):
            self.nums[i] += self.nums[i-1]

    def sumRange(self, i, j):
        if i==0:
            return self.nums[j]
        return self.nums[j]-self.nums[i-1]
