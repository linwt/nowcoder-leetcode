# 将两个数组相加、排序，再算中位数
class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        nums = nums1 + nums2
        nums.sort()
        length = len(nums)
        if length%2 == 0:
            return (nums[length/2-1] + nums[length/2])/2.0
        else:
            return nums[length/2]