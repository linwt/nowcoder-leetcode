# 回溯法，判断指定行列位置能否放，能放就递归判断下一行的所有列，不能放就回溯
class Solution(object):
    def solveNQueens(self, n):
        # 初始化棋盘和全局数组
        board, res = [['.']*n for _ in range(n)], []
        # 调用递归，设置初值
        self.dfs(board, n, 0, res)
        return res

    # 参数：当前棋盘，皇后个数，当前行，全局结果数组
    def dfs(self, board, n, row, res):
        # 终止条件，最后一行已放完，满足要求，存入结果数组，返回空结束当前递归，回溯到上一步
        if row == n:
            res.append([''.join(i) for i in board])
            return
        # 遍历当前行的每一列
        for i in range(n):
            # 剪枝条件。判断当前位置能否放，不能放则跳过。若当前行每一列都不能放，则结束当前递归，回溯到上一步
            if not self.canPlace(row, i, n, board):
                continue
            # 能放则在当前棋盘做标记
            board[row][i] = 'Q'
            # 再继续递归判断下一行
            self.dfs(board, n, row+1, res)
            # 递归完成后回溯，还原初始化设置，继续遍历判断下一列
            board[row][i] = '.'

    def canPlace(self, row, col, n, board):
        for i in range(1, row+1):
            # 判断同一列上是否有Q
            if board[row-i][col] == 'Q':
                return False
            # 判断左斜线是否有Q
            if col-i >= 0 and board[row-i][col-i] == 'Q':
                return False
            # 判断右斜线是否有Q
            if col+i < n and board[row-i][col+i] == 'Q':
                return False
        return True


class Solution2(object):
    def solveNQueens(self, n):
        if n == 0:
            return []
        res = []

        # 参数：
        def gen(solution, col, diff, add):
            row = len(solution)
            if len(col) == n:
                # line是每一行皇后放的位置
                res.append(['.' * line + 'Q' + '.' * (n - line - 1) for line in solution])
                return
            # 遍历当前行的每一列
            for index in range(n):
                # 如果当前位置不与其它皇后冲突
                if (index not in col) and (index - row not in diff) and (index + row not in add):
                    # 则记录当前皇后可到达的位置
                    col.add(index)
                    diff.add(index - row)
                    add.add(index + row)
                    # 记录当前皇后可放位置，递归判断下一行
                    gen(solution + [index], col, diff, add)
                    # 递归完成后回溯，还原初始设置，继续遍历判断下一列
                    col.remove(index)
                    diff.remove(index - row)
                    add.remove(index + row)

        # 三个集合存放皇后能达到的列、左斜线、右斜线
        gen([], set(), set(), set())
        return res