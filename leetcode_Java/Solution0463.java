// 岛屿的周长


/*
深度优先搜索：
1、两层for循环遍历二维数组每个位置
2、当碰到陆地时，通过深度优先搜索往上下左右四个方向扩散陆地
3、走过的陆地标记为2。当越界时或碰到海水时，返回边长1。当碰到遍历过的陆地，返回0。累加边长得到周长
 */
class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == 1) {
                    return dfs(grid, row, col);
                }
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int row, int col) {
        int n = grid.length, m = grid[0].length;
        if (row < 0 || col < 0 || row >= n || col >= m) {
            return 1;
        }
        if (grid[row][col] == 0) {
            return 1;
        }
        if (grid[row][col] == 2) {
            return 0;
        }
        grid[row][col] = 2;
        return dfs(grid, row - 1, col)
                + dfs(grid, row + 1, col)
                + dfs(grid, row, col - 1)
                + dfs(grid, row, col + 1);
    }
}