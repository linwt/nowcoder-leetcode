// 122. 买卖股票的最佳时机 II


/*
动态规划：
1、定义dp数组：
  dp[i][0] 表示第i天交易结束后不持有股票的最大利润
  dp[i][1] 表示第i天交易结束后持有股票的最大利润
2、初始化
  dp[0][0] = 0 表示第0天不持有股票，最大利润为0。创建数组时默认为0，可省略
  dp[0][1] = -prices[0] 表示第0天持有股票，最大利润为-prices[0]
3、状态转移方程
    dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
  第i天不持有股票        前一天不持有股票   前一天持有股票且今天卖出
    dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);  // 注意：可以买卖多次，所以买入时的利润包含之前所得利润，即dp[i - 1][0] - prices[i]
   第i天持有股票         前一天持有股票    前一天不持有股票且今天买入
4、遍历dp数组填表：一个for循环遍历数组，根据状态转移方程直接取dp数组的已知结果计算未知结果
5、返回结果：最后一个不持有股票的状态就是结果

二维dp数组更新过程
prices = [7,1,5,3,6,4]
0  -7
0  -1
4  -1
4   1
7   1
7   3
 */
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}


/*
动态规划
1、状态压缩：每一天的状态只与前一天的状态有关，使用变量存储状态 dp[i][0]、dp[i][1]
2、定义状态：
   dp0 表示第i天交易结束后不持有股票的最大利润
   dp1 表示第i天交易结束后持有股票的最大利润
 */
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 1; i < n; i++) {
            int newDp0 = Math.max(dp0, dp1 + prices[i]);
            int newDp1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = newDp0;
            dp1 = newDp1;
        }
        return dp0;
    }
}


/*
贪心：根据股票价格画出折线图，由于交易次数不限，因此把每次上涨差值累加就是最大利润
 */
class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            res += Math.max(0, prices[i] - prices[i - 1]);
        }
        return res;
    }
}