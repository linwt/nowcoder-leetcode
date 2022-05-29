# dp[i][j] 表示s1的前i个字符和s2前j个字符想要相等的最小ASCII删除和
class Solution(object):
    def minimumDeleteSum(self, s1, s2):
        n, m = len(s1), len(s2)
        dp = [[0]*(m+1) for _ in range(n+1)]
        # 初始化首行首列
        for i in range(1, n+1):
            dp[i][0] = dp[i-1][0] + ord(s1[i-1])
        for j in range(1, m+1):
            dp[0][j] = dp[0][j-1] + ord(s2[j-1])
        # 遍历每个元素，获取状态值
        for i in range(1, n+1):
            for j in range(1, m+1):
                if s1[i-1] == s2[j-1]:
                    # 两字符相等，则当前状态等于前一状态
                    dp[i][j] = dp[i-1][j-1]
                else:
                    # 两字符不相等，则比较删除哪个字符最终ASCII删除和最小
                    dp[i][j] = min(dp[i-1][j] + ord(s1[i-1]), dp[i][j-1] + ord(s2[j-1]))

        return dp[-1][-1]