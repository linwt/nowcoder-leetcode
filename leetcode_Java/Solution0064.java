// 64. 最小路径和


/*
动态规划：
1、题目：给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。说明：每次只能向下或者向右移动一步。
2、题目简化：求从 (0,0) 到达 (m-1,n-1) 位置的最小路径和
3、定义dp数组：本题可以直接在原数组操作。grid[i][j] 表示到达 (i,j) 位置的最小路径和
4、初始化：
  1）二维dp数组不用扩容，直接根据dp数组的定义就可以直观地对应进行初始化
  2）首行首列的路径和进行累加初始化
5、状态转移方程：grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]); 即上方或左方的最小路径和
6、遍历顺序：两个for循环遍历二维dp数组每个位置，根据状态转移方程计算该位置的最小路径和并填表，直到终点，获得结果
 */
class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        for (int i = 1; i < n; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int j = 1; j < m; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[n - 1][m - 1];
    }
}