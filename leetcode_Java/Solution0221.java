// 221. 最大正方形


/*
动态规划：
1、定义dp数组：dp[row][col] 表示以 matrix[row-1][col-1] 为右下角的正方形的最大边长
2、初始化：由于状态转移方程要用到上一行和上一列，所以二维dp数组扩容首行首列，初始化为0
3、状态转移方程：
  若某格子值为 1，则以此为右下角的正方形的最大边长为 左面的正方形、上面的正方形、左上的正方形 的最小边长加1
  左、上、左上取最小边长，是因为木桶原理，只能取最小才能构成正方形，其他两个边长肯定大于等于最小边长，三个正方形加上当前格子，就能构成新的边长为 最小边长加1 的正方形
4、遍历dp数组填表：两个for循环遍历二维dp数组，当格子为1时，根据状态转移方程填表
5、返回结果：边计算边保留最大边长，最后返回面积

以最后一个为例：
 matrix         dp
1  1  1  1       1  1  1  1
1  1  1  1       1  2  2  2
1  1  1  1  ==>  1  2  3  3  ==>  dp[3][3] = min(2, 3, 3) + 1
0  1  1  1       0  1  2  3
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        if (m < 1 || n < 1) {
            return 0;
        }
        int maxSide = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int row = 1; row <= m; row++) {
            for (int col = 1; col <= n; col++) {
                if (matrix[row - 1][col - 1] == '1') {
                    dp[row][col] = Math.min(dp[row - 1][col - 1], Math.min(dp[row - 1][col], dp[row][col - 1])) + 1;
                    maxSide = Math.max(maxSide, dp[row][col]);
                }
            }
        }
        return maxSide * maxSide;
    }
}