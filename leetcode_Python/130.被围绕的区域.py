# 深度优先搜索
class Solution(object):
    def solve(self, board):
        # 判断为空的情况
        if not board:
            return []

        m, n = len(board), len(board[0])
        d = ((1, 0), (-1, 0), (0, 1), (0, -1))

        def dfs(x, y):
            # 变换符号为'Y'
            board[x][y] = 'Y'
            # 对四个方向进行搜索
            for dx, dy in d:
                nx, ny = x + dx, y + dy
                if 0 <= nx < m and 0 <= ny < n and board[nx][ny] == 'O':
                    dfs(nx, ny)

        for i in range(m):
            for j in range(n):
                # 对四条边上的'O'进行深度优先搜索
                if i-1<0 or i+1==m or j-1<0 or j+1==n:
                    if board[i][j] == 'O':
                        dfs(i, j)

        # 再次遍历矩阵，将被包围的'O'改为'X'，将'Y'改为原来的'O'
        for i in range(m):
            for j in range(n):
                if board[i][j] == 'O':
                    board[i][j] = 'X'
                if board[i][j] == 'Y':
                    board[i][j] = 'O'

        return board


# 广度优先搜索
import collections
class Solution2(object):
    def solve(self, board):
        if not board:
            return []

        m, n = len(board), len(board[0])
        d = ((1, 0), (-1, 0), (0, 1), (0, -1))

        for i in range(m):
            for j in range(n):
                if i-1<0 or i+1==m or j-1<0 or j+1==n:
                    if board[i][j] == 'O':
                        q = collections.deque()
                        q.appendleft((i, j))
                        while q:
                            x, y = q.pop()
                            board[x][y] = 'Y'
                            for dx, dy in d:
                                nx, ny = x + dx, y + dy
                                if 0 <= nx < m and 0 <= ny < n and board[nx][ny] == 'O':
                                    q.appendleft((nx, ny))

        for i in range(m):
            for j in range(n):
                if board[i][j] == 'O':
                    board[i][j] = 'X'
                if board[i][j] == 'Y':
                    board[i][j] = 'O'

        return board