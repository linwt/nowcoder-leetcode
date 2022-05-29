# 遍历数组，遇到不重复的值就按顺序复制到前面
class Solution(object):
    def removeDuplicates(self, nums):
        if not nums:
            return 0
        j = 0
        for i in range(len(nums)):
            if nums[i] != nums[j]:
                nums[j+1] = nums[i]
                j += 1
        return j+1