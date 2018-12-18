# 去重排序
class Solution(object):
    def thirdMax(self, nums):
        n = sorted(list(set(nums)))
        if len(n) < 3:
            return n[-1]
        return n[-3]