class Solution(object):
    def solveSudoku(self, board):
        # 判断当前行列是否可以放数字n
        def is_valid(row, col, n):
            for i in range(9):
                # 判断每一列是否有数字重复
                if board[row][i] == n:
                    return False
                # 判断每一行是否有数字重复
                if board[i][col] == n:
                    return False
                # 判断每一个小方格是否有数字重复
                if board[row // 3 * 3 + i / 3][col // 3 * 3 + i % 3] == n:
                    return False
            return True

        def solve(board):
            # 遍历整个表格
            for row in range(9):
                for col in range(9):
                    # 若非空则跳过
                    if board[row][col] != '.':
                        continue
                    # 在空格处枚举1-9，递归求解
                    for n in range(1, 10):
                        # 判断该数字是否合法，不合法则跳过
                        if not is_valid(row, col, str(n)):
                            continue
                        # 若合法，则将该数字填入表格
                        board[row][col] = str(n)
                        # 递归判断下一空格，若全部满足条件，返回True
                        if solve(board):
                            return True
                        # 若不满足条件，则回溯，还原初始化设置
                        board[row][col] = '.'
                    # 1-9都不合法，返回False
                    return False
            # 整个表格遍历完成，数字填充完毕，返回True
            return True

        solve(board)
        return board