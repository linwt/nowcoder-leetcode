# 方法一
class Solution(object):
    def intersection(self, nums1, nums2):
        res = []
        for i in set(nums1):
            if i in nums2:
                res.append(i)
        return res

# 方法二
class Solution(object):
    def intersection(self, nums1, nums2):
        return list(set(nums1).intersection(set(nums2)))