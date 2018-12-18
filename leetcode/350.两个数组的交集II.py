# 使用字典
class Solution(object):
    def intersect(self, nums1, nums2):
        res = []
        d = collections.Counter(nums2)
        for i in nums1:
            if d[i] > 0:
                res.append(i)
                d[i] -= 1
        return res