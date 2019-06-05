# 动态规划，dp[i]记录增加元素A[i]与前面构成等差数列时，新增的等差数列子数组个数，且个数刚好为前一状态新增个数加1
class Solution(object):
    def numberOfArithmeticSlices(self, A):
        dp = [0]*len(A)
        for i in range(2, len(A)):
            if A[i] - A[i-1] == A[i-1] - A[i-2]:
                dp[i] = dp[i-1] + 1
        return sum(dp)
