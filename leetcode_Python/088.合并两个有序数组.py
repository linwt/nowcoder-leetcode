# 将num2的元素添加到nums1后面，再排序
class Solution(object):
    def merge(self, nums1, m, nums2, n):
        for i in range(n):
            nums1[i+m] = nums2[i]
        nums1.sort()