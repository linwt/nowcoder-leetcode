# 滑动窗口，每次加上后一个数，减去第一个数，获取当前窗口的和再与最大和比较
class Solution(object):
    def findMaxAverage(self, nums, k):
        max_sum = cur = sum(nums[:k])
        for i in range(len(nums)-k):
            cur += nums[i+k]-nums[i]
            max_sum = max(max_sum, cur)
        return max_sum/float(k)