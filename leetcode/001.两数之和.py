# 方法一：暴力破解
class Solution(object):
    def twoSum(self, nums, target):
        for i in range(len(nums)-1):
            for j in range(i+1, len(nums)):
                if target-nums[i]==nums[j]:
                    return [i, j]

# 方法二：字典存储值和索引
class Solution(object):
    def twoSum(self, nums, target):
        d = {}
        for i,num in enumerate(nums):
            if target-num in d:
                return [d[target-num], i]
            else:
                d[num] = i