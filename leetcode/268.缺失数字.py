# 方法一：求出差集
class Solution(object):
    def missingNumber(self, nums):
        nums2 = [i for i in range(len(nums)+1)]
        return int(list(set(nums2).difference(set(nums)))[0])

# 方法二：等差数列前n项和：n(n-1)/2
class Solution(object):
    def missingNumber(self, nums):
        return len(nums) * (len(nums) + 1) / 2 - sum(nums)