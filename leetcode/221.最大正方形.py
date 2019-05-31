# dp[i][j]表示以i, j位置为右下角顶点能组成的最大正方形的边长
# 当matrix[i][j]=1时，能组成的正方形为左边、上边、左上能组成的正方形边长的最小值加1
# 最小值是因为只要存在一个0，就没法组成更大的正方形
class Solution(object):
    def maximalSquare(self, matrix):
        m = len(matrix)
        if m == 0:
            return 0
        n = len(matrix[0])
        dp = [[0]*n for _ in range(m)]
        # 初始化数组
        for i in range(n):
            dp[0][i] = int(matrix[0][i])
        for j in range(m):
            dp[j][0] = int(matrix[j][0])
        # 遍历每个位置，记录状态值
        for i in range(1, m):
            for j in range(1, n):
                if matrix[i][j] == '1':
                    dp[i][j] = 1 + min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1])

        return max(map(max, dp)) ** 2