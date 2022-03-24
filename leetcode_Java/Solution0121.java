// 121. 买卖股票的最佳时机


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
    dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);  // 注意：只能买卖一次，所以买入时的利润为-prices[i]
   第i天持有股票         前一天持有股票     今天买入
4、遍历dp数组填表：一个for循环遍历数组，根据状态转移方程直接取dp数组的已知结果计算未知结果
5、返回结果：最后一个不持有股票的状态就是结果

二维dp数组更新过程
prices = [7,1,5,3,6,4]
0  -7
0  -1
4  -1
4  -1
5  -1
5  -1
 */
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }
}


/*
动态规划思路：
1、定义dp数组：dp[i]表示第i天交易结束后可获得的最大利润（天数从0开始，与索引对应，方便理解）
2、状态转移方程：dp[i] = Math.max(dp[i - 1], prices[i] - minPrice)
                        第i-1天可获得的最大利润  第i天卖出可获得的最大利润
3、初始化：dp[0] = 0，第0天的最大利润为0
4、遍历dp数组填表：一个for循环遍历数组，根据状态转移方程直接取dp数组的已知结果计算未知结果
5、返回结果：最后一个状态就是结果
 */
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        dp[0] = 0;
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
        }
        return dp[n - 1];
    }
}


/*
思路：
1、动态规划维护的dp数组，存放的每个元素只用一次就不需要了，因此可以直接用一个变量来表示利润最大值
2、遍历列表，计算到当天为止的价格最小值、利润最大值
 */
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = 99999, maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
}