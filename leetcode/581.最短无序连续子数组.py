# 将原数组排序后，从左右两边的元素开始与排序后的数组比较，得到左边两边第一个不相同的元素的索引，相减得到区间长度
class Solution(object):
    def findUnsortedSubarray(self, nums):
        nums2 = sorted(nums)
        i, j = 0, len(nums)-1
        while i < j:
            if nums[i] == nums2[i]:
                i += 1
            elif nums[j] == nums2[j]:
                j -= 1
            else:
                return j-i+1
        return 0