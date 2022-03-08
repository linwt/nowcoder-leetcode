// 121. 买卖股票的最佳时机


/*
动态规划思路：
1、dp[i]表示前i+1天可获得的最大利润
2、初始条件：dp[0] = 0，第1天的最大利润为0
3、状态转移方程：dp[i] = Math.max(dp[i - 1], prices[i] - minPrice)
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