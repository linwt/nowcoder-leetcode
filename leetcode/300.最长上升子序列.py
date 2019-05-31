# dp[i] 表示以 nums[i] 结尾的最长上升子序列的长度
# nums：[10, 9, 2, 5, 3, 7, 101, 18] 为例：
# dp：  [1,  1, 1, 2, 2, 3,  4,   4]
class Solution(object):
    def lengthOfLIS(self, nums):
        n = len(nums)
        if n < 2:
            return n
        dp = [1]*n
        for i in range(1, n):
            for j in range(i):
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i], dp[j]+1)
        return max(dp)