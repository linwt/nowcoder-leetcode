# 方法一：暴力破解
class Solution(object):
    def numMagicSquaresInside(self, grid):
        count = 0
        for i in range(len(grid)-2):
            for j in range(len(grid[0])-2):
                # 判断矩阵是否在1-9之间
                magic = sorted([grid[i][j], grid[i][j+1], grid[i][j+2],
                                grid[i+1][j], grid[i+1][j+1], grid[i+1][j+2],
                                grid[i+2][j], grid[i+2][j+1], grid[i+2][j+2]])
                if magic[0] < 1 or magic[-1] > 9:
                    continue
                # 三行
                g1 = grid[i][j] + grid[i][j+1] + grid[i][j+2]
                g2 = grid[i+1][j] + grid[i+1][j+1] + grid[i+1][j+2]
                g3 = grid[i+2][j] + grid[i+2][j+1] + grid[i+2][j+2]
                # 三列
                g4 = grid[i][j] + grid[i+1][j] + grid[i+2][j]
                g5 = grid[i][j+1] + grid[i+1][j+1] + grid[i+2][j+1]
                g6 = grid[i][j+2] + grid[i+1][j+2] + grid[i+2][j+2]
                # 两对角
                g7 = grid[i][j] + grid[i+1][j+1] + grid[i+2][j+2]
                g8 = grid[i][j+2] + grid[i+1][j+1] + grid[i+2][j]
                # 所有值相等
                if len(set([g1, g2, g3, g4, g5, g6, g7, g8])) == 1:
                    count += 1
        return count


# 方法二：幻方矩阵中心须为5，行列对角的和为15
class Solution(object):
    def numMagicSquaresInside(self, grid):
        counte = 0
        for row in range(len(grid) - 2):
            for col in range(len(grid[0]) - 2):
                sub_matrix = [[grid[row + i][col + j] for j in range(3)] for i in range(3)]
                if self.magic_square(sub_matrix):
                    counte += 1
        return counte

    def magic_square(self, matrix):
        is_number_right = all(1 <= matrix[i][j] <= 9 for i in range(3) for j in range(3))
        is_row_right = all(sum(row) == 15 for row in matrix)
        is_col_right = all(sum(col) == 15 for col in [[matrix[i][j] for i in range(3)] for j in range(3)])
        is_diagonal_right = matrix[1][1] == 5 and matrix[0][0] + matrix[-1][-1] == 10 and matrix[0][-1] + matrix[-1][0] == 10
        return is_number_right and is_row_right and is_col_right and is_diagonal_right