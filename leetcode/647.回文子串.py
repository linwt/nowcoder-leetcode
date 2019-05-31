# dp[i][j]表示以s[i]开头s[j]结尾的字符串是否为回文串
class Solution(object):
    def countSubstrings(self, s):
        n = len(s)
        dp = [[1]*n for _ in range(n)]
        for i in range(n-2, -1, -1):
            for j in range(i+1, n):
                # 当前状态由前一状态和首尾两字符是否相等共同判断
                dp[i][j] = dp[i+1][j-1] and s[i] == s[j]
        # 计算二维数组的和并减去下三角的和
        return sum(map(sum, dp)) - (n*(n-1)/2)


# 暴力破解，遍历所有子串，是回文串则加1
class Solution2(object):
    def countSubstrings(self, s):
        res = 0
        for i in range(len(s)):
            for j in range(i+1, len(s)+1):
                if s[i:j] == s[i:j][::-1]:
                    res += 1
        return res