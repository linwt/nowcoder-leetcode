// 47. 礼物的最大价值


// 64. 最小路径和（力扣，思路相同，本题是 最大路径和）
/*
1、题目简化：求从 (0,0) 到达 (m-1,n-1) 位置的最大路径和
2、定义dp数组：本题可以直接在原数组操作。grid[i][j] 表示到达 (i,j) 位置的最大路径和
3、初始化：
  1）二维dp数组不用扩容，直接根据dp数组的定义就可以直观地对应进行初始化
  2）首行首列的路径和进行累加初始化
4、状态转移方程：grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]); 即上方或左方的最大路径和
5、遍历顺序：两个for循环遍历二维dp数组每个位置，根据状态转移方程计算该位置的最大路径和并填表，直到终点，获得结果
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
                grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[n - 1][m - 1];
    }
}


public class Solution {
    public int maxValue (int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}