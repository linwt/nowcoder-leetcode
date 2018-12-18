class Solution(object):
    def dominantIndex(self, nums):
        max_num = max(nums)
        nums2 = nums[:]
        nums.remove(max_num)
        for i in nums:
            if i*2 > max_num:
                return -1
        return nums2.index(max_num)