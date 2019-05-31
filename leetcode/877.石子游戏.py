# dp[i][j]：表示在piles中下标i至下标j之间的玩家1所拿石子总数与玩家2所拿石子总数之差。dp[i][j]>0 表示玩家1赢
# 子问题：dp[i+1][j]和dp[i][j-1]
# 初始状态：dp的初始状态是i=j即只有一个石子堆，由于玩家1先拿，则dp[i][j]=piles[i]
# 状态方程：dp[i][j] = max(piles[i] - dp[i+1][j], piles[j] - dp[i][j-1])
class Solution(object):
    def stoneGame(self, piles):
        dp = [[0]*len(piles) for _ in range(len(piles))]
        # 初始化只有一个石头堆的情况
        for i in range(len(piles)):
            dp[i][i] = piles[i]
        # 每增加一个石头堆，则计算当前石头堆两个到n个的情况
        for i in range(len(piles)-2, -1, -1):
            for j in range(i+1, len(piles)):
                dp[i][j] = max(piles[i] - dp[i+1][j], piles[j] - dp[i][j-1])
        return dp[0][-1] > 0


class Solution2(object):
    def stoneGame(self, piles):
        dp = [[0]*len(piles) for _ in range(len(piles))]
        for i in range(len(piles)):
            dp[i][i] = piles[i]
        # 依次计算相邻两个石头堆到n个石头堆的情况
        for i in range(1, len(piles)):
            for j in range(len(piles)-i):
                dp[j][j+i] = max(piles[j] - dp[j+1][j+i], piles[j+i] - dp[j][j+i-1])
        return dp[0][-1] > 0