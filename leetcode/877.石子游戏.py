# dp[i][j]：表示在piles中下标i至下标j之间的玩家1比玩家2多拿的石子数。dp[i][j]>0 表示玩家1赢
# 子问题：dp[i+1][j]和dp[i][j-1]
# 初始状态：dp的初始状态是i=j即只有一个石子堆，由于玩家1先拿，则dp[i][j]=piles[i]
# 状态方程：dp[i][j] = max(piles[i] - dp[i+1][j], piles[j] - dp[i][j-1])
# 状态方程理解：由于在有限石子堆中双方都要取最优，当前玩家1取piles[i]或piles[j]时，则上一步反过来代表玩家2取到最优即dp[i+1][j]或dp[i][j-1]，故要相减
class Solution(object):
    def stoneGame(self, piles):
        n = len(piles)
        dp = [[0]*n for _ in range(n)]
        # 初始化只有一个石头堆的情况
        for i in range(n):
            dp[i][i] = piles[i]
        # 每增加一个石头堆，则计算当前石头堆两个到n个的情况
        for i in range(n-2, -1, -1):
            for j in range(i+1, n):
                dp[i][j] = max(piles[i] - dp[i+1][j], piles[j] - dp[i][j-1])
        return dp[0][-1] > 0
# 5 1 4 1
# 0 4 1 4
# 0 0 3 2
# 0 0 0 5
