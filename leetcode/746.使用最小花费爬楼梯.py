# 动态规划，找到最优子结构，求到达每一阶的最小成本，倒数第一和倒数第二的最小值即为解
class Solution(object):
    def minCostClimbingStairs(self, cost):
        n = len(cost)
        dp = {}
        # dp = [0] * n      # 也可使用数组
        dp[0], dp[1] = cost[0], cost[1]
        for i in range(2, n):
            dp[i] = min(dp[i-2] + cost[i], dp[i-1] + cost[i])
        return min(dp[n-1], dp[n-2])