class Solution(object):
    def searchInsert(self, nums, target):
        if target in nums:
            return nums.index(target)
        for i in range(len(nums)):
            if nums[i] > target:
                return i
        return i+1