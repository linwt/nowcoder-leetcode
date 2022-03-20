// 188. 买卖股票的最佳时机 IV


/*
动态规划：
1、定义dp数组：
  1）存在三种「状态」：天数、交易次数、是否持有股票，因此定义三维dp
  2）dp[i][j][0] 表示第i天，已经进行了j次交易，不持有股票，获取的最大利润
    dp[i][j][1] 表示第i天，已经进行了j次交易，持有股票，获取的最大利润
2、状态转移方程
  dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
  dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
3、初始化：
  dp[0][j][0] = 0 表示第0天，不持有股票，任意交易次数，获取的最大利润都为0。创建数组时默认为0，可省略
  dp[0][j][1] = -prices[0] 表示第0天，持有股票，任意交易次数，获取的最大利润都为-prices[0]
4、遍历dp数组填表：第一层遍历天数，第二层遍历交易次数，根据状态转移方程填表。计算当前状态只跟前一天有关，所以两个for循环顺序先后都可以。
5、返回结果：最后一个状态就是结果。即最后一天，已经进行了k次交易，不持有股票，获取的最大利润
6、其他细节：
  1）数组至少包含两个元素，即至少有两天才能完成一次交易，否则返回0
  2）一次交易需要买入和卖出共两天，最大交易次数为数组长度的一半，所以交易次数进行比较取最小值即可
  3）dp数组定义时k+1，因为交易次数可能为0-k次，或者说计算状态时j-1可能为0，要用到交易次数为0的状态，所以总共有k+1个状态
  4）[买,卖][买,卖]... 将买入股票时作为一次交易，也就是在买入股票的时候交易次数加1，所以 dp[i - 1][j - 1][0] - prices[i] 买入时前一天的交易次数为j-1，买入后交易次数为j

三维数组更新过程，左上角表示天数，行表示交易次数，列表示是否持有股票
k = 2, prices = [3,2,6,5,0,3]
0         1         2         3         4         5
  0   0     0   0     0   0     0   0     0   0     0   0
  0  -3     0  -2     4  -2     4  -2     4   0     4   0
  0  -3     0  -2     0  -2     4  -1     4   4     7   4
 */
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }
        k = Math.min(k, n / 2);
        int[][][] dp = new int[n][k + 1][2];
        for (int j = 1; j <= k; j++) {
            dp[0][j][0] = 0;
            dp[0][j][1] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }
}


/*
动态规划，状态压缩，去掉天数的维度，交易次数和是否持有股票构成的二维数组变成滚动数组
 */
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }
        k = Math.min(k, n / 2);
        int[][] dp = new int[k + 1][2];
        for (int j = 1; j <= k; j++) {
            dp[j][0] = 0;
            dp[j][1] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[j][0] = Math.max(dp[j][0], dp[j][1] + prices[i]);
                dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] - prices[i]);
            }
        }
        return dp[k][0];
    }
}