class Solution(object):
    def shortestBridge(self, A):
        m, n = len(A), len(A[0])
        d = [(1, 0), (-1, 0), (0, 1), (0, -1)]

        # 深度优先搜索，将一片岛屿置为-1
        def dfs(x, y):
            A[x][y] = -1
            for dx, dy in d:
                nx, ny = x + dx, y + dy
                if 0 <= nx < m and 0 <= ny < n and A[nx][ny] == 1:
                    dfs(nx, ny)

        # 找到一个1，将其所在的A岛屿置为-1
        flag = 0
        for i in range(m):
            for j in range(n):
                if A[i][j] == 1:
                    dfs(i, j)
                    flag = 1
                if flag:
                    break
            if flag:
                break

        # 将B岛屿每个位置添加到队列中
        q = []
        for i in range(m):
            for j in range(n):
                if A[i][j] == 1:
                    q.append((i, j, 0))

        # 广度优先搜索，B岛屿中某个位置先到达A岛屿，则返回其路径长度
        while q:
            x, y, r = q.pop(0)
            for dx, dy in d:
                nx, ny = x + dx, y + dy
                if 0 <= nx < m and 0 <= ny < n:
                    if A[nx][ny] == 0:
                        A[nx][ny] = 1
                        q.append((nx, ny, r + 1))
                    if A[nx][ny] == -1:
                        return r