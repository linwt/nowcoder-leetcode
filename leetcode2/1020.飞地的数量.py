# 从四条边上为 1 的位置向内搜索，将相连的 1 都改为 0,剩下的都是没有连接到边界的 1，计算1的个数所求数量
class Solution(object):
    def numEnclaves(self, A):
        d = [(0, 1), (0, -1), (-1, 0), (1, 0)]
        m, n = len(A), len(A[0])

        def dfs(x, y):
            A[x][y] = 0
            for dx, dy in d:
                nx, ny = x + dx, y + dy
                if 0 <= nx < m and 0 <= ny < n and A[nx][ny] == 1:
                    dfs(nx, ny)

        for i in range(m):
            for j in range(n):
                if (i == 0 or i == m - 1 or j == 0 or j == n - 1) and A[i][j] == 1:
                    dfs(i, j)

        res = 0
        for i in range(m):
            res += sum(A[i])
        return res