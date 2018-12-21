class Solution(object):
    def islandPerimeter(self, grid):
        res = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    res += 4
                    # 下边为1时不用管，上边为1时再一起减2
                    if i>0 and grid[i-1][j]==1:
                        res -= 2
                    # 右边为1时不用管，左边为1时再一起减2
                    if j>0 and grid[i][j-1]==1:
                        res -= 2
        return res
