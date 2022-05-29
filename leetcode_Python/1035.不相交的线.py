# 相当于寻找最长公共子串
class Solution(object):
    def maxUncrossedLines(self, A, B):
        n, m = len(A), len(B)
        dp = [[0]*(n+1) for _ in range(m+1)]
        for i in range(m):
            for j in range(n):
                if A[j] == B[i]:
                    dp[i+1][j+1] = dp[i][j] + 1
                else:
                    dp[i+1][j+1] = max(dp[i][j+1], dp[i+1][j])
        return dp[-1][-1]

#       2 5 1 2 5
#
#     0 0 0 0 0 0
# 10  0 0 0 0 0 0
# 5   0 0 1 1 1 1
# 2   0 1 1 1 2 2
# 1   0 1 1 2 2 2
# 5   0 1 2 2 2 3
# 2   0 1 2 2 3 3