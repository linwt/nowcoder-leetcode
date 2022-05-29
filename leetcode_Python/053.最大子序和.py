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

# 方法二：动态规划，dp[i]表示以下标i元素结尾的数组最大和
class Solution(object):
    def maxSubArray(self, nums):
        n = len(nums)
        dp = [nums[0] for _ in range(n)]
        for i in range(1, n):
            # 前一状态最大和加上当前元素值，与当前元素值比较出较大者
            dp[i] = max(dp[i-1] + nums[i], nums[i])
        return max(dp)
