# 使用集合去重，若长度与原数组相同，则无重复元素，否则有重复
class Solution(object):
    def containsDuplicate(self, nums):
        s = set(nums)
        if len(s) == len(nums):
            return False
        return True

