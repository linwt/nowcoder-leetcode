// 279. 完全平方数


/*
动态规划：
1、dp[i]表示和为i的完全平方数的最少数量
2、遍历1-n，填充dp[i]元素
3、初始化 dp[i] = i，表示最后情况全部由1相加，数量为i
4、状态转移方程：dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
5、j*j 是一个完全平方数，i-j*j 表示减去一个完全平方数的值，dp[i-j*j] 表示和为 i-j*j 完全平方数的最少数量，dp[i-j*j] + 1 表示和为i的完全平方数的数量
6、构成i有多个完全平方数相加，所以遍历j，每次减去一个j*j的完全平方数，由旧状态加1直接得到当前值数量，比较得到最少数量
 */
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}