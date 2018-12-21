class Solution(object):
    def singleNumber(self, nums):
        d = collections.Counter(nums)
        res = [k for k in d if d[k]==1]
        return res[0]