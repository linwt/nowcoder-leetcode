// 1020. 飞地的数量


/*
深度优先搜索：
1、遍历四条边界，将边界的岛屿都淹没，剩下的就是封闭岛屿
2、两层for循环遍历二维数组每个位置，当碰到陆地时，通过深度优先搜索往上下左右四个方向扩散陆地，将陆地淹没，并累加记录封闭岛屿中陆地的个数
 */
class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length, m = grid[0].length, res = 0;
        for (int row = 0; row < n; row++) {
            dfs(grid, row, 0);
            dfs(grid, row, m - 1);
        }
        for (int col = 0; col < m; col++) {
            dfs(grid, 0, col);
            dfs(grid, n - 1, col);
        }
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == 1) {
                    res += dfs(grid, row, col);
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int row, int col) {
        int n = grid.length, m = grid[0].length;
        if (row < 0 || col < 0 || row >= n || col >= m) {
            return 0;
        }
        if (grid[row][col] == 0) {
            return 0;
        }
        grid[row][col] = 0;
        return 1
                + dfs(grid, row + 1, col)
                + dfs(grid, row - 1, col)
                + dfs(grid, row, col + 1)
                + dfs(grid, row, col - 1);
    }
}