// 279. 完全平方数


/*
动态规划：
1、题目：给你一个整数 n，返回 和为n 的完全平方数的最少数量。完全平方数是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
2、题目简化：求和为n的完全平方数的最少数量
3、定义dp数组：dp[i]表示和为i的完全平方数的最少数量
4、初始化：
  1）一维dp数组扩容：增加和为0这一最小规模的情况
  2）dp[i] = i，表示最坏情况全部由1相加，数量为i
5、状态转移方程：dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
  1）j*j 是一个完全平方数，i-j*j 表示减去一个完全平方数的值，dp[i-j*j] 表示和为 i-j*j 完全平方数的最少数量，dp[i-j*j] + 1 表示和为i的完全平方数的数量
  2）构成i有多个完全平方数相加，所以遍历j，每次减去一个j*j的完全平方数，由旧状态加1直接得到当前值数量，比较得到最少数量
6、遍历dp数组填表：一个for循环遍历dp数组的未知位置，另一个for循环遍历完全平方数，根据条件获取dp数组的已知位置，根据状态转移方程取已知结果汇总计算未知结果
7、返回结果：最后一个状态就是结果
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