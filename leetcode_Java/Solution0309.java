// 309. 最佳买卖股票时机含冷冻期


/*
动态规划：
1、定义dp数组
  dp[i][0] 表示第i天交易结束后，持有股票，获取的最大利润
  dp[i][1] 表示第i天交易结束后，不持有股票，处于冷冻期，获取的最大利润（第i天卖出股票后就处于冷冻期，则第i+1天不能买入股票）
  dp[i][2] 表示第i天交易结束后，不持有股票，不处于冷冻期，获取的最大利润
2、状态转移方程
  dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);  // 今天持有股票。则前一天持有股票；或者前一天不持有股票、非冷冻期，且今天买入股票
  dp[i][1] = dp[i - 1][0] + prices[i];  // 今天不持有股票，处于冷冻期。则前一天持有股票，且今天卖出股票
  dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);  // 今天不持有股票，不处于冷冻期。则前一天不持有股票，处于冷冻期；或者前一天不持有股票，不处于冷冻期
3、初始化
  dp[0][0] = -prices[0] 表示第0天交易结束后，持有股票，获取的最大利润为-prices[0]
  dp[0][1] = dp[0][2] = 0 表示第0天交易结束后，不持有股票，获取的最大利润为0。创建数组时默认为0，可省略
4、遍历dp数组填表：一个for循环遍历数组，根据状态转移方程直接取dp数组的已知结果计算未知结果
5、返回结果：第i天交易结束后，不持有股票的两个状态比较获取的最大利润
 */
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0];
        dp[0][1] = dp[0][2] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[n - 1][1], dp[n - 1][2]);
    }
}


/*
动态规划：状态压缩，使用变量存储状态
1、状态压缩：每一天的状态只与前一天的状态有关，使用变量存储状态 dp[i][0]、dp[i][1]、dp[i][2]
2、定义状态：
  dp0 表示第i天交易结束后，持有股票，获取的最大利润
  dp1 表示第i天交易结束后，不持有股票，处于冷冻期，获取的最大利润
  dp2 表示第i天交易结束后，不持有股票，不处于冷冻期，获取的最大利润
 */
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp0 = -prices[0], dp1 = 0, dp2 = 0;
        for (int i = 1; i < n; i++) {
            int newDp0 = Math.max(dp0, dp2 - prices[i]);
            int newDp1 = dp0 + prices[i];
            int newDp2 = Math.max(dp1, dp2);
            dp0 = newDp0;
            dp1 = newDp1;
            dp2 = newDp2;
        }
        return Math.max(dp1, dp2);
    }
}