class Solution(object):
    def maxAreaOfIsland(self, grid):
        m, n, maxArea = len(grid), len(grid[0]), 0

        # 获取岛屿面积
        def getArea(grid, x, y):
            # 符合条件的土地，将其置0，并累加四个方向的土地，得到岛屿的面积
            if 0 <= x < m and 0 <= y < n and grid[x][y] == 1:
                grid[x][y] = 0
                return 1 + getArea(grid, x + 1, y) + getArea(grid, x - 1, y) + getArea(grid, x, y + 1) + getArea(grid, x, y - 1)
            return 0

        # 遍历每个位置，得到每个位置上的面积并更新最大面积
        for i in range(m):
            for j in range(n):
                area = getArea(grid, i, j)
                maxArea = area if area > maxArea else maxArea
        return maxArea
