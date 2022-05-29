class Solution(object):
    def updateMatrix(self, matrix):
        m, n = len(matrix), len(matrix[0])
        # 结果矩阵初始化为-1，表示未搜索
        q, res = [], [[-1]*n for _ in range(m)]
        d = [(1, 0), (-1, 0), (0, 1), (0, -1)]

        # 从值为0开始搜索，将其添加到队列
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    res[i][j] = 0
                    q += [(i, j)]

        # 搜索四个方向
        for x, y in q:
            for dx, dy in d:
                nx, ny = x + dx, y + dy
                # 将未搜索的区域赋值，值为上个区域值加1，并将新区域添加到队列中继续搜素偶
                if 0 <= nx < m and 0 <= ny < n and res[nx][ny] == -1:
                    res[nx][ny] = res[x][y] + 1
                    q += [(nx, ny)]

        return res