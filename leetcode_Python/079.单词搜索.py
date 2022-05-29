class Solution(object):
    def exist(self, board, word):
        m, n = len(board), len(board[0])
        d = [(0, 1), (0, -1), (1, 0), (-1, 0)]

        def dfs(x, y, word, board):
            # 递归终止条件，全部搜索完成
            if not word:
                return True
            # 记录字符，然后变换该字符，避免重用
            c = board[x][y]
            board[x][y] = '.'
            # 遍历搜索四个方向的字符
            for dx, dy in d:
                nx, ny = x+dx, y+dy
                if 0 <= nx < m and 0 <= ny < n and board[nx][ny] == word[0] and dfs(nx, ny, word[1:], board):
                    return True
            # 四个方向都不满足条件，回溯，返回False
            board[x][y] = c
            return False

        # 遍历二维矩阵每个字符，深度优先搜索
        for i in range(m):
            for j in range(n):
                # 有一条路径满足条件
                if board[i][j] == word[0] and dfs(i, j, word[1:], board):
                    return True
        # 全部不满足条件
        return False