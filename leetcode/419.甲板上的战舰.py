# 遍历时如果为'X'，并且其左边和上边不为'X'，则个数加1
class Solution(object):
    def countBattleships(self, board):
        res = 0
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == 'X':
                    if (i > 0 and board[i-1][j] == 'X') or (j > 0 and board[i][j-1] == 'X'):
                        continue
                    res += 1
        return res