// 200. 岛屿数量


/*
深度优先搜索：
1、两层for循环遍历二维数组每个位置
2、当碰到陆地时，通过深度优先搜索往上下左右四个方向扩散陆地，将陆地淹没，并记录岛屿的个数
3、由于二维数组每个位置都会走过，所以能够找到所有的岛屿
 */
class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length, res = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == '1') {
                    res += 1;
                    dfs(grid, row, col);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int row, int col) {
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == '1') {
            grid[row][col] = '0';
            dfs(grid, row - 1, col);
            dfs(grid, row + 1, col);
            dfs(grid, row, col - 1);
            dfs(grid, row, col + 1);
        }
    }
}


/*
同上。递归函数中，上面方法是通过判断满足条件则执行递归；下面方法是设置终止条件，不满足终止则执行递归。
 */
class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length, res = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == '1') {
                    res += 1;
                    dfs(grid, row, col);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int row, int col) {
        int n = grid.length, m = grid[0].length;
        if (row < 0 || col < 0 || row >= n || col >= m) {
            return;
        }
        if (grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }
}


/*
同上。创建方向二维数组，遍历递归
 */
class Solution {
    private int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length, res = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == '1') {
                    res += 1;
                    dfs(grid, row, col);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int row, int col) {
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == '1') {
            grid[row][col] = '0';
            for (int[] d : direction) {
                dfs(grid, row + d[0], col + d[1]);
            }
        }
    }
}


/*
使用额外的二维数组标记访问过的位置，不改动原二维数组
 */
class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length, res = 0;
        boolean[][] visit = new boolean[n][m];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == '1' && !visit[row][col]) {
                    res += 1;
                    dfs(grid, row, col, visit);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int row, int col, boolean[][] visit) {
        int n = grid.length, m = grid[0].length;
        if (row < 0 || col < 0 || row >= n || col >= m) {
            return;
        }
        if (grid[row][col] == '0' || visit[row][col]) {
            return;
        }
        visit[row][col] = true;
        dfs(grid, row - 1, col, visit);
        dfs(grid, row + 1, col, visit);
        dfs(grid, row, col - 1, visit);
        dfs(grid, row, col + 1, visit);
    }
}