# 遍历数组，如果元素递增，则次数加1，并更新最大次数。如果非递增，则次数重置1
class Solution(object):
    def findLengthOfLCIS(self, nums):
        if not nums:
            return 0
        res = count = 1
        for i in range(1, len(nums)):
            if nums[i] > nums[i-1]:
                count += 1
                res = max(res, count)
            else:
                count = 1
        return res