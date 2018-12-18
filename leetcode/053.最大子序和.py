# 方法一：累加判断
class Solution(object):
    def maxSubArray(self, nums):
        sum = 0
        max_sum = nums[0]
        for num in nums:
            sum += num
            if sum > max_sum:
                max_sum = sum
            if sum < 0:
                sum = 0
        return max_sum

# 方法二：动态规划，用数组保存当前最大值
class Solution(object):
    def maxSubArray(self, nums):
        n = len(nums)
        max_sum = [nums[0] for _ in range(n)]
        for i in range(1, n):
            max_sum[i] = max(max_sum[i-1] + nums[i], nums[i])
        return max(max_sum)