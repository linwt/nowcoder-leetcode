// 123. 买卖股票的最佳时机 III


/*
与 188.买卖股票的最佳时机IV 解法相同，将k值设置为2即可
 */
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }
        int[][][] dp = new int[n][3][2];
        for (int j = 1; j <= 2; j++) {
            dp[0][j][0] = 0;
            dp[0][j][1] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= 2; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][2][0];
    }
}


/*
状态压缩，去掉天数的维度，交易次数和是否持有股票构成的二维数组变成滚动数组
 */
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }
        int[][] dp = new int[3][2];
        for (int j = 1; j <= 2; j++) {
            dp[j][0] = 0;
            dp[j][1] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= 2; j++) {
                dp[j][0] = Math.max(dp[j][0], dp[j][1] + prices[i]);
                dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] - prices[i]);
            }
        }
        return dp[2][0];
    }
}


/*
动态规划，多个一维dp数组，记录多种状态
 */
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] buy1 = new int[n];
        int[] sell1 = new int[n];
        int[] buy2 = new int[n];
        int[] sell2 = new int[n];
        buy1[0] = -prices[0]; sell1[0] = 0;
        buy2[0] = -prices[0]; sell2[0] = 0;
        for (int i = 1; i < n; i++) {
            buy1[i] = Math.max(buy1[i - 1], -prices[i]);
            sell1[i] = Math.max(sell1[i - 1], buy1[i - 1] + prices[i]);
            buy2[i] = Math.max(buy2[i - 1], sell1[i - 1] - prices[i]);
            sell2[i] = Math.max(sell2[i - 1], buy2[i - 1] + prices[i]);
        }
        return sell2[n-1];
    }
}


/*
动态规划：
1、将多个一维数组写成一个二维数组，行表示天数，四列表示四种状态
2、定义dp数组：
  dp[i][0] 表示第i天交易结束后，进行过第一次买入，获取的最大利润
  dp[i][1] 表示第i天交易结束后，进行过第一次卖出，获取的最大利润
  dp[i][2] 表示第i天交易结束后，进行过第二次买入，获取的最大利润
  dp[i][3] 表示第i天交易结束后，进行过第二次卖出，获取的最大利润
 */
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][4];
        dp[0][0] = dp[0][2] = -prices[0];
        dp[0][1] = dp[0][3] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + prices[i]);
        }
        return dp[n - 1][3];
    }
}


/*
动态规划：状态压缩
1、状态定义：由于最多可以完成两笔交易，因此在任意一天结束之后，会处于以下五个状态中的一种
  1）没有操作。利润为0，不用记录
  2）buy1：第一次买入，获取的最大利润
  3）sell1：第一次卖出，获取的最大利润
  4）buy2：第二次买入，获取的最大利润
  5）sell2：第二次卖出，获取的最大利润
2、状态转移：
   buy1 = Math.max(buy1, -prices[i]);  // 在第i天没有操作，取前一天buy1的状态。或者在没有操作的前提下以prices[i]的价格买入股票
   sell1 = Math.max(sell1, buy1 + prices[i]); // 在第i天没有操作，取前一天sell1的状态。或者在第一次买入的前提下以prices[i]的价格卖出股票
   buy2 = Math.max(buy2, sell1 - prices[i]);  // 在第i天没有操作，取前一天buy2的状态。或者在第一次卖出的前提下以prices[i]的价格买入股票
   sell2 = Math.max(sell2, buy2 + prices[i]);  // 在第i天没有操作，取前一天sell2的状态。或者在第二次买入的前提下以prices[i]的价格卖出股票
3、初始化：第0天的状态
  buy1 = -prices[0] 表示以prices[0]的价格买入股票
  sell1 = 0 表示在同一天买入并且卖出，利润为0
  buy2 = -prices[0] 表示以prices[0]的价格买入股票
  sell2 = 0 表示在同一天买入并且卖出，利润为0
4、遍历更新状态：一个for循环遍历数组，根据状态转移方程直接取dp数组的已知结果计算未知结果
5、返回结果：直接返回sell2
   1）无交易情况，sell2为0，返回sell2
   2）只完成交易一次，由于存在同一天买卖的情况，所以sell1可以转移到sell2，返回sell2
   3）完成两次交易，返回sell2
 */
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}