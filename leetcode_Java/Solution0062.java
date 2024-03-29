// 62. 不同路径


/*
动态规划二维dp：自底向上
1、题目：一个机器人位于一个 m x n 网格的左上角，机器人每次只能向下或者向右移动一步，机器人试图达到网格的右下角，问总共有多少条不同的路径？
2、题目简化：求从(0,0)到(m-1,n-1)的不同路径条数
3、定义dp数组：dp[i][j]表示到达位置(i,j)的不同路径条数
4、初始化：
  1）二维dp数组不用扩容，直接根据dp数组的定义就可以直观地对应进行初始化
  2）首行首列只有一条路径，初始化为1
5、状态转移方程：dp[i][j] = dp[i - 1][j] + dp[i][j - 1] 即上方和左方的不同路径条数相加
6、遍历dp数组填表：两个for循环遍历二维dp数组每个位置，根据状态转移方程计算该位置不同路径条数并填表，直到终点，获得结果
7、返回结果：最后一个状态就是结果
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}


/*
动态规划状态压缩：自底向上
1、由于每次状态更新只用到上一行的记录，因此可以压缩成一维数组
2、滚动数组：二维数组更新变成在一维数组上滚动更新
3、dp[j-1]表示当前行刚更新的值（左方元素），dp[j]表示上一行的旧值（上方元素），相加后覆盖dp[j]表示上一行用过了不需要了
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}


/*
递归 + 备忘录：自顶向下
1、定义二维数组作为备忘录，初始化为-1，记录递归过程已经计算路径的位置，防止重复递归计算
2、从终点位置开始，递归计算路径条数
2、定义递归函数
  1）递归函数含义：dfs(i,j)表示到达位置(i,j)的不同路径条数
  2）终止条件：碰到左边界或上边界就返回1，或者该位置备忘录有值则直接返回
  3）递归调用：(i,j)位置的不同路径条数由上方和左方的不同路径条数相加，计算完结果存入备忘录并返回结果
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        return dfs(memo, m - 1, n - 1);
    }

    private int dfs(int[][] memo, int i, int j) {
        if (i == 0 || j == 0) {
            return 1;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        memo[i][j] = dfs(memo, i - 1, j) + dfs(memo, i, j - 1);
        return memo[i][j];
    }
}