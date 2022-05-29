# 动态规划，求出打劫到每间房屋时能偷窃到的最高金额
class Solution(object):
    def rob(self, nums):
        n = len(nums)
        if n==0:
            return 0
        elif n==1 or n==2:
            return max(nums)
        dp = [0] * n
        dp[0], dp[1] = nums[0], max(nums[0], nums[1])
        for i in range(2, n):
            dp[i] = max(dp[i-2] + nums[i], dp[i-1])
        return dp[-1]