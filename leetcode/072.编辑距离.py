# dp[i][j] 表示 word1[:i] 和 word2[:j] 的编辑距离
class Solution(object):
    def minDistance(self, word1, word2):
        m, n = len(word1), len(word2)
        dp = [[0]*(n+1) for _ in range(m+1)]
        # 初始化数组
        for i in range(1, n+1):
            dp[0][i] = i
        for j in range(1, m+1):
            dp[j][0] = j
        for i in range(1, m+1):
            for j in range(1, n+1):
                if word1[i-1] == word2[j-1]:
                    # 两字符相等，则当前状态等于前一状态
                    dp[i][j] = dp[i-1][j-1]
                else:
                    # 添加：dp[i][j-1]表面上是删除word2最后一个字符，换个角度理解是在word1添加word2的最后一个字符，两者相等抵消
                    # 删除：dp[i-1][j]相当于删除word1最后一个字符
                    # 替换：dp[i-1][j-1]相当于替换word1最后一个字符为word2最后一个字符
                    # 取三种操作中之前状态的最小操作数，每次操作后操作数需加1
                    dp[i][j] = 1 + min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1])
        return dp[-1][-1]

#      r o s
#    0 1 2 3
# h  1 1 2 3
# o  2 2 1 2
# r  3 2 2 2
# s  4 3 3 2
# e  5 4 4 3