# 用集合存放去重后的数，再统计每个数出现次数
class Solution(object):
    def majorityElement(self, nums):
        s = set(nums)
        for i in s:
            if nums.count(i) > len(nums)/2:
                return i