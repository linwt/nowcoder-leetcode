# 广度优先搜索，从1开始，向四周搜索0，并记录每个0的搜索步数，返回最大的搜索步数
class Solution(object):
    def maxDistance(self, grid):
        m, n = len(grid), len(grid[0])
        if sum([sum(grid[i]) for i in range(m)]) in [0, m * n]:
            return -1

        q, res = [], [[-1] * n for _ in range(m)]
        d = [(1, 0), (-1, 0), (0, 1), (0, -1)]

        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    res[i][j] = 0
                    q.append((i, j))

        while q:
            x, y = q.pop(0)
            for dx, dy in d:
                nx, ny = x + dx, y + dy
                if 0 <= nx < m and 0 <= ny < n and res[nx][ny] == -1:
                    res[nx][ny] = res[x][y] + 1
                    q.append((nx, ny))

        return max([max(res[i]) for i in range(m)])