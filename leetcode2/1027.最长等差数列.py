# 暴力破解
class Solution(object):
    def longestArithSeqLength(self, A):
        res = 0
        for i in range(len(A)-2):
            for j in range(i+1, len(A)-1):
                count = 2
                diff = A[j] - A[i]
                cur = A[j] + diff
                for k in range(j+1, len(A)):
                    if A[k] == cur:
                        count += 1
                        cur += diff
                res = max(res, count)
        return res


# 动态规划
# dp[i][diff]表示以下标为i的元素结尾且公差为diff的等差子序列的最大长度
# 由于使用数组内存开销太大而且公差可能是负数，所以选择使用字典来代替数组
class Solution2(object):
    def longestArithSeqLength(self, A):
        n = len(A)
        dp = [{} for _ in range(n)]
        res = 2
        for i in range(1, n):
            for j in range(0, i):
                diff = A[i] - A[j]
                dp[i][diff] = dp[j].get(diff, 1) + 1
                res = max(res, dp[i][diff])
        return res