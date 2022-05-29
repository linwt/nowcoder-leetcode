# 获取原数组的总和、去重数组的总和、含重复元素的总和，求差可求得重复元素和缺失元素
class Solution(object):
    def findErrorNums(self, nums):
        sum1 = sum([i for i in range(1, len(nums)+1)])
        sum2 = sum(set(nums))
        sum3 = sum(nums)
        return [sum3-sum2, sum1-sum2]