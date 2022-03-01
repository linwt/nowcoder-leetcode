// 统计子岛屿


/*
1、两层for循环遍历并比较两个二维数组的每个位置，当grid1是海水且grid2是陆地时，说明grid2的这块陆地不是子岛屿，要淹没掉这块岛屿，遍历结束后剩下的就是子岛屿
2、两层for循环遍历二维数组grid2，计算岛屿的数量
 */
class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length, m = grid1[0].length, res = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid1[row][col] == 0 && grid2[row][col] == 1) {
                    dfs(grid2, row, col);
                }
            }
        }
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid2[row][col] == 1) {
                    res++;
                    dfs(grid2, row, col);
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int row, int col) {
        int n = grid.length, m = grid[0].length;
        if (row < 0 || col < 0 || row >= n || col >= m) {
            return;
        }
        if (grid[row][col] == 0) {
            return;
        }
        grid[row][col] = 0;
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }
}