// 695. 岛屿的最大面积


/*
深度优先搜索：
1、两层for循环遍历二维数组每个位置
2、当碰到陆地时，通过深度优先搜索往上下左右四个方向扩散陆地
3、记录岛屿中陆地的个数。当越界或碰到海水时返回0，碰到陆地时返回1，并将走过的陆地淹没，累加陆地的个数得到岛屿的面积
4、比较每个岛屿的面积得到最大岛屿面积
 */
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length, res = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == 1) {
                    res = Math.max(res, dfs(grid, row, col));
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