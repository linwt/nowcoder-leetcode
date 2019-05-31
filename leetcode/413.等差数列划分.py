# 动态规划，dp[i]记录以元素A[i]结尾的等差数列的个数
# 每增加一个元素，如果与前面数组形成等差数列，则以该元素结尾的等差数列个数为前一元素结尾的等差数列个数加1
class Solution(object):
    def numberOfArithmeticSlices(self, A):
        dp = [0]*len(A)
        for i in range(2, len(A)):
            if A[i] - A[i-1] == A[i-1] - A[i-2]:
                dp[i] = dp[i-1] + 1
        return sum(dp)